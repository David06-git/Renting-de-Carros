import java.util.Scanner;
public class Menus {
Scanner sc = new Scanner(System.in);
Metodos metodos = new Metodos();
public void menuPrincipal() {
int opcion;
do {
System.out.println("\n========== SISTEMA RENTING ==========");
System.out.println("1. Gestion clientes");
System.out.println("2. Gestion vehiculos");
System.out.println("3. Gestion contratos renting");
System.out.println("4. Imprimir informe general");
System.out.println("5. Salir");
opcion = metodos.validarEntero("Seleccione una opcion: ");
switch (opcion) {
case 1:

menuClientes();
break;
case 2:
menuVehiculos();
break;
case 3:
menuContratos();
break;
case 4:
metodos.imprimirInformeGeneral();
break;
case 5:
System.out.println("Saliendo del sistema...");
break;
default:
System.out.println("Opcion invalida.");
}
} while (opcion != 5);
}
public void menuClientes() {
int opcion;
do {
System.out.println("\n===== GESTION CLIENTES =====");
System.out.println("1. Registrar cliente");
System.out.println("2. Modificar cliente");
System.out.println("3. Eliminar cliente");
System.out.println("4. Buscar cliente");
System.out.println("5. Volver");
opcion = metodos.validarEntero("Seleccione: ");
switch (opcion) {
case 1:
metodos.registrarCliente();
break;
case 2:
metodos.modificarCliente();
break;
case 3:
metodos.eliminarCliente();
break;
case 4:
metodos.buscarCliente();
break;
case 5:
break;
default:
System.out.println("Opcion invalida.");
}
} while (opcion != 5);
}
public void menuVehiculos() {
int opcion;
do {
System.out.println("\n===== GESTION VEHICULOS =====");
System.out.println("1. Registrar vehiculo");
System.out.println("2. Modificar vehiculo");
System.out.println("3. Eliminar vehiculo");
System.out.println("4. Buscar vehiculo");
System.out.println("5. Volver");
opcion = metodos.validarEntero("Seleccione: ");
switch (opcion) {
case 1:
metodos.registrarVehiculo();
break;
case 2:
metodos.modificarVehiculo();
break;
case 3:
metodos.eliminarVehiculo();
break;
case 4:
metodos.buscarVehiculo();
break;

case 5:
break;
default:
System.out.println("Opcion invalida.");
}
} while (opcion != 5);
}
public void menuContratos() {
int opcion;
do {
System.out.println("\n===== GESTION CONTRATOS =====");
System.out.println("1. Registrar contrato");
System.out.println("2. Modificar contrato");
System.out.println("3. Finalizar contrato");
System.out.println("4. Buscar contrato");
System.out.println("5. Volver");
opcion = metodos.validarEntero("Seleccione: ");
switch (opcion) {
case 1:
metodos.registrarContrato();
break;
case 2:
metodos.modificarContrato();
break;
case 3:
metodos.finalizarContrato();
break;
case 4:
metodos.buscarContrato();
break;
case 5:
break;
default:
System.out.println("Opcion invalida.");
}
} while (opcion != 5);

}
}