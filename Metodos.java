
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);

    ArrayList<Cliente> vector_clientes = new ArrayList<>();
    ArrayList<Vehiculo> vector_vehiculos = new ArrayList<>();
    ArrayList<ContratoRenting> vector_contratos = new ArrayList<>();

    // ================= VALIDACIONES =================

    public String validarSoloLetras(String mensaje) {

        System.out.print(mensaje);
        String dato = sc.nextLine();

        if (dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            return dato;
        }

        System.out.println("ERROR. Solo letras.");
        return validarSoloLetras(mensaje);
    }

    public String validarSoloNumeros(String mensaje) {

        System.out.print(mensaje);
        String dato = sc.nextLine();

    if (dato.matches("[0-9]+")) {
        
        if (dato.length() <= 10) {
            return dato;
        } else {
            System.out.println("ERROR. El numero no puede superar los 10 digitos.");
        }
    } else {
        System.out.println("ERROR. Solo numeros.");
    }

        return validarSoloNumeros(mensaje);
    }

    public String validarTexto(String mensaje) {

        System.out.print(mensaje);
        String dato = sc.nextLine();

        if (!dato.trim().isEmpty()) {
            return dato;
        }

        System.out.println("ERROR. Campo vacio.");
        return validarTexto(mensaje);
    }

    public int validarEntero(String mensaje) {

        try {

            System.out.print(mensaje);
            int dato = Integer.parseInt(sc.nextLine());

            if (dato > 0) {
                return dato;
            }

            System.out.println("Debe ser positivo.");
            return validarEntero(mensaje);

        } catch (Exception e) {

            System.out.println("ERROR. Ingrese un numero entero.");
            return validarEntero(mensaje);
        }
    }

    public float validarFloat(String mensaje) {

        try {

            System.out.print(mensaje);
            float dato = Float.parseFloat(sc.nextLine());

            if (dato > 0) {
                return dato;
            }

            System.out.println("Debe ser positivo.");
            return validarFloat(mensaje);

        } catch (Exception e) {

            System.out.println("ERROR. Ingrese un numero valido.");
            return validarFloat(mensaje);
        }
    }


    public String validarPlaca(String mensaje){
        System.out.println(mensaje);
        String dato = sc.nextLine();

        if (dato.trim().isEmpty()){
            System.out.println("ERROR. Campo vacio.");
        return validarPlaca(mensaje);
        }

        if (dato.matches("[a-zA-Z]{3}[0-9]{3}")) {
        return dato.toUpperCase();
        } else {
        System.out.println("ERROR. Placa invalida. (Ejemplo: AAA123).");
        return validarPlaca(mensaje);
        }
    }

    public Cliente validarExistencia(String mensaje){
        String cedula = validarSoloNumeros(mensaje);
        Cliente cliente = buscarClienteObjeto(cedula);

        if (cliente == null) {
        System.out.println("ERROR: El cliente con cedula " + cedula + " no esta registrado.");
        System.out.println("Por favor, ingrese la cedula de un cliente valido.");
        return validarExistencia(mensaje);
    }
    return cliente;

    }

    public Vehiculo validarExistenciaCarro(String mensaje){
        String placa = validarPlaca(mensaje);
        Vehiculo carro = buscarVehiculoObjeto(placa);

        if (carro == null) {
        System.out.println("ERROR: El vehiculo con placa " + placa + " no esta registrado.");
        System.out.println("Por favor, ingrese una placa valida.");
        return validarExistenciaCarro(mensaje); 
        }
        return carro;
    }

    public String validarTraccion(){
        System.out.println("Elija que traccion desea: ");
        System.out.println("1. 4x2 ");
        System.out.println("2. 4x4 ");

        int opcion = validarEntero("Seleccione: ");

        if (opcion == 1) {
            return "4x2";
            } else if (opcion == 2) {
        return "4x4";
            } else {
        System.out.println("ERROR. Opcion invalida. Elija 1 o 2.");
        return validarTraccion(); // Llamada recursiva si mete otro número
        }
    }

    // ================= CLIENTES =================

    public void registrarCliente() {

        String cedula = validarSoloNumeros("Cedula: ");

        if (buscarClienteObjeto(cedula) != null) {

            System.out.println("Cliente ya registrado.");
            return;
        }

        String nombre = validarSoloLetras("Nombre: ");
        String apellido = validarSoloLetras("Apellido: ");
        String telefono = validarSoloNumeros("Telefono: ");
        String direccion = validarTexto("Direccion: ");
        String licencia = validarTexto("Licencia: ");

        Cliente cliente = new Cliente(
                cedula,
                nombre,
                apellido,
                telefono,
                direccion,
                licencia
        );

        vector_clientes.add(cliente);

        System.out.println("Cliente registrado correctamente.");
    }

    public Cliente buscarClienteObjeto(String cedula) {

        for (Cliente cliente : vector_clientes) {

            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }

        return null;
    }

    public void buscarCliente() {

        String cedula = validarSoloNumeros("Cedula: ");

        Cliente cliente = buscarClienteObjeto(cedula);

        if (cliente != null) {

            System.out.println(cliente);

        } else {

            System.out.println("Cliente no encontrado.");
        }
    }

    public void modificarCliente() {

        String cedula = validarSoloNumeros("Cedula: ");

        Cliente cliente = buscarClienteObjeto(cedula);

        if (cliente != null) {

            cliente.setNombre(
                    validarSoloLetras("Nuevo nombre: "));

            cliente.setApellido(
                    validarSoloLetras("Nuevo apellido: "));

            cliente.setTelefono(
                    validarSoloNumeros("Nuevo telefono: "));

            cliente.setDireccion(
                    validarTexto("Nueva direccion: "));

            cliente.setLicenciaConduccion(
                    validarTexto("Nueva licencia: "));

            System.out.println("Cliente modificado correctamente.");

        } else {

            System.out.println("Cliente no encontrado.");
        }
    }

    public void eliminarCliente() {

        String cedula = validarSoloNumeros("Cedula: ");

        Cliente cliente = buscarClienteObjeto(cedula);

        if (cliente != null) {

            vector_clientes.remove(cliente);

            for (int i = 0; i < vector_contratos.size(); i++) {

                if (vector_contratos.get(i)
                        .getCedulaCliente()
                        .equals(cedula)) {

                    vector_contratos.remove(i);
                    i--;
                }
            }

            System.out.println("Cliente eliminado correctamente.");

        } else {

            System.out.println("Cliente no encontrado.");
        }
    }

    // ================= VEHICULOS =================

    public Vehiculo buscarVehiculoObjeto(String placa) {

        for (Vehiculo vehiculo : vector_vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null;
    }

    public void registrarVehiculo() {

        System.out.println("1. Carro Sedan");
        System.out.println("2. Camioneta SUV");

        int opcion = validarEntero("Seleccione: ");

        String placa = validarPlaca("Placa: ");

        if (buscarVehiculoObjeto(placa) != null) {

            System.out.println("Vehiculo ya registrado.");
            return;
        }

        String marca = validarSoloLetras("Marca: ");
        int modelo = validarEntero("Modelo: ");
        float precio = validarFloat("Precio diario: ");

        if (opcion == 1) {

            String combustible =
                    validarSoloLetras("Tipo combustible: ");

            String transmision =
                    validarSoloLetras("Transmision: ");

            CarroSedan carro = new CarroSedan(
                    placa,
                    marca,
                    modelo,
                    precio,
                    "disponible",
                    combustible,
                    transmision
            );

            vector_vehiculos.add(carro);

        } else if (opcion == 2) {

            String traccion = validarTraccion();

            float maletero =
                    validarFloat("Capacidad maletero: ");

            CamionetaSUV suv = new CamionetaSUV(
                    placa,
                    marca,
                    modelo,
                    precio,
                    "disponible",
                    traccion,
                    maletero
            );

            vector_vehiculos.add(suv);

        } else {

            System.out.println("Opcion invalida.");
            return;
        }

        System.out.println("Vehiculo registrado correctamente.");
    }

    public void buscarVehiculo() {

        String placa = validarPlaca("Placa: ");

        Vehiculo vehiculo = buscarVehiculoObjeto(placa);

        if (vehiculo != null) {

            System.out.println(
                    vehiculo.mostrarInformacion());

        } else {

            System.out.println("Vehiculo no encontrado.");
        }
    }

    public void modificarVehiculo() {

        String placa = validarPlaca("Placa: ");

        Vehiculo vehiculo = buscarVehiculoObjeto(placa);

        if (vehiculo != null) {

            vehiculo.setMarca(
                    validarSoloLetras("Nueva marca: "));

            vehiculo.setModelo(
                    validarEntero("Nuevo modelo: "));

            vehiculo.setPrecioDiario(
                    validarFloat("Nuevo precio: "));

            System.out.println("Vehiculo modificado correctamente.");

        } else {

            System.out.println("Vehiculo no encontrado.");
        }
    }

    public void eliminarVehiculo() {

        String placa = validarPlaca("Placa: ");

        Vehiculo vehiculo = buscarVehiculoObjeto(placa);

        if (vehiculo != null) {

            vector_vehiculos.remove(vehiculo);

            for (int i = 0; i < vector_contratos.size(); i++) {

                if (vector_contratos.get(i)
                        .getPlacaVehiculo()
                        .equalsIgnoreCase(placa)) {

                    vector_contratos.remove(i);
                    i--;
                }
            }

            System.out.println("Vehiculo eliminado correctamente.");

        } else {

            System.out.println("Vehiculo no encontrado.");
        }
    }

    // ================= CONTRATOS =================

    public ContratoRenting buscarContratoObjeto(String id) {

        for (ContratoRenting contrato : vector_contratos) {

            if (contrato.getIdContrato()
                    .equalsIgnoreCase(id)) {

                return contrato;
            }
        }

        return null;
    }

    public boolean clienteTieneContratoActivo(String cedula) {

        for (ContratoRenting contrato : vector_contratos) {

            if (contrato.getCedulaCliente().equals(cedula)
                    && contrato.isActivo()) {

                return true;
            }
        }

        return false;
    }

    public void registrarContrato() {

        String id = validarTexto("ID contrato: ");

        if (buscarContratoObjeto(id) != null) {

            System.out.println("Contrato ya existe.");
            return;
        }

        Cliente cliente = validarExistencia("Cedula cliente: ");

        if (clienteTieneContratoActivo(cliente.getCedula())) {

            System.out.println(
                    "El cliente ya tiene un vehiculo alquilado.");

            return;
        }

        Vehiculo vehiculo = validarExistenciaCarro("Placa vehiculo: ");

        if (vehiculo.getEstado()
                .equalsIgnoreCase("alquilado")) {

            System.out.println(
                    "Vehiculo alquilado actualmente.");

            return;
        }

        String fechaInicio =
                validarTexto("Fecha inicio: ");

        String fechaFin =
                validarTexto("Fecha fin: ");

        int dias =
                validarEntero("Total dias: ");

        float valorTotal =
                dias * vehiculo.getPrecioDiario();

        ContratoRenting contrato =
                new ContratoRenting(
                        id,
                        cliente.getCedula(), 
                        vehiculo.getPlaca(),
                        fechaInicio,
                        fechaFin,
                        dias,
                        valorTotal,
                        true
                );

        vector_contratos.add(contrato);

        vehiculo.setEstado("alquilado");

        System.out.println("Contrato registrado correctamente.");
    }

    public void buscarContrato() {

        String id = validarTexto("ID contrato: ");

        ContratoRenting contrato =
                buscarContratoObjeto(id);

        if (contrato != null) {

            System.out.println(contrato);

        } else {

            System.out.println("Contrato no encontrado.");
        }
    }

    public void modificarContrato() {

        String id = validarTexto("ID contrato: ");

        ContratoRenting contrato =
                buscarContratoObjeto(id);

        if (contrato != null) {

            contrato.setFechaInicio(
                    validarTexto("Nueva fecha inicio: "));

            contrato.setFechaFin(
                    validarTexto("Nueva fecha fin: "));

            contrato.setTotalDias(
                    validarEntero("Nuevo total dias: "));

            Vehiculo vehiculo =
                    buscarVehiculoObjeto(
                            contrato.getPlacaVehiculo());

            contrato.setValorTotal(
                    contrato.getTotalDias()
                    * vehiculo.getPrecioDiario());

            System.out.println(
                    "Contrato modificado correctamente.");

        } else {

            System.out.println("Contrato no encontrado.");
        }
    }

    public void finalizarContrato() {

        String id = validarTexto("ID contrato: ");

        ContratoRenting contrato =
                buscarContratoObjeto(id);

        if (contrato != null) {

            contrato.setActivo(false);

            Vehiculo vehiculo =
                    buscarVehiculoObjeto(
                            contrato.getPlacaVehiculo());

            if (vehiculo != null) {

                vehiculo.setEstado("disponible");
            }

            System.out.println(
                    "Contrato finalizado correctamente.");

        } else {

            System.out.println("Contrato no encontrado.");
        }
    }

    // ================= INFORMES =================

    public void imprimirInformeGeneral() {

        float ingresos = 0;

        System.out.println("\n========== CLIENTES ==========");

        for (Cliente cliente : vector_clientes) {

            imprimir(cliente);
        }

        System.out.println("\n========== VEHICULOS ==========");

        for (Vehiculo vehiculo : vector_vehiculos) {

            imprimir(vehiculo);
        }

        System.out.println("\n========== CONTRATOS ACTIVOS ==========");

        for (ContratoRenting contrato : vector_contratos) {

            if (contrato.isActivo()) {

                imprimir(contrato);
            }

            ingresos += contrato.getValorTotal();
        }

        System.out.println("\n========== CONTRATOS FINALIZADOS ==========");

        for (ContratoRenting contrato : vector_contratos) {

            if (!contrato.isActivo()) {

                imprimir(contrato);
            }
        }

        System.out.println("\nTOTAL INGRESOS: " + ingresos);
    }

    // ================= SOBRECARGA =================

    public void imprimir(Cliente cliente) {

        System.out.println(cliente);
    }

    public void imprimir(Vehiculo vehiculo) {

        System.out.println(
                vehiculo.mostrarInformacion());
    }

    public void imprimir(ContratoRenting contrato) {

        System.out.println(contrato);
    }
}