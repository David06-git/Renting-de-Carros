import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
        System.out.println("ERROR. Solo letras.");
        return validarSoloLetras(mensaje);
    }

    public boolean clienteTieneContratoActivoPorCedula(String cedula) {

    for (ContratoRenting contrato : vector_contratos) {

        if (contrato.getCedulaCliente().equals(cedula)
                && contrato.isActivo()) {

            return true;
        }
    }

    return false;
}

public boolean vehiculoTieneContratoActivo(String placa) {

    for (ContratoRenting contrato : vector_contratos) {

        if (contrato.getPlacaVehiculo().equalsIgnoreCase(placa)
                && contrato.isActivo()) {

            return true;
        }
    }

    return false;
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

    public int validarModelo() {

    int anioActual = java.time.LocalDate.now().getYear();

    int modelo = validarEntero("Modelo: ");

    if (modelo >= 1900 && modelo <= anioActual + 1) {
        return modelo;
    }

    System.out.println("ERROR. Ingrese un modelo valido entre 1900 y "
            + (anioActual + 1));

    return validarModelo();
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

    public String validarFecha(String mensaje) {

    try {

        System.out.print(mensaje);
        String fechaTexto = sc.nextLine();

        LocalDate.parse(fechaTexto, formatoFecha);

        return fechaTexto;

    } catch (Exception e) {

        System.out.println("ERROR. Formato invalido. Use dd/MM/yyyy.");
        return validarFecha(mensaje);
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
        while (telefonoExiste(telefono)) {

    System.out.println("ERROR. Ya existe un cliente registrado con ese telefono.");
    telefono = validarSoloNumeros("Telefono: ");
}
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

    if (clienteTieneContratoActivoPorCedula(cedula)) {

        System.out.println(
                "No se puede eliminar el cliente porque tiene un contrato activo.");
        return;
        }
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
        int modelo = validarModelo();
        float precio = validarFloat("Precio diario: ");

        if (opcion == 1) {

            String combustible =
                    validarSoloLetras("Tipo combustible: ");
                    maletero
            );

            vector_vehiculos.add(suv);

        } else {

            System.out.println("Opcion invalida.");

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
