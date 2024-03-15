import java.util.HashMap;
import java.util.Scanner;

public class GestionClientes {

    static HashMap<String, HashMap<String, String>> clientes = new HashMap<>();

    public static void agregarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el NIF del cliente: ");
        String nif = scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el correo del cliente: ");
        String correo = scanner.nextLine();
        System.out.print("¿Es un cliente preferente? (SI/NO): ");
        String preferente = scanner.nextLine();
        
        HashMap<String, String> cliente = new HashMap<>();
        cliente.put("nombre", nombre);
        cliente.put("dirección", direccion);
        cliente.put("teléfono", telefono);
        cliente.put("correo", correo);
        cliente.put("preferente", preferente);
        
        clientes.put(nif, cliente);
        System.out.println("Cliente agregado correctamente.");
        scanner.close();
    }

    public static void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el NIF del cliente que desea eliminar: ");
        String nif = scanner.nextLine();
        if (clientes.containsKey(nif)) {
            clientes.remove(nif);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con ese NIF.");
        }
        scanner.close();
    }

    public static void mostrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el NIF del cliente que desea mostrar: ");
        String nif = scanner.nextLine();
        if (clientes.containsKey(nif)) {
            HashMap<String, String> cliente = clientes.get(nif);
            System.out.println("Datos del cliente:");
            System.out.println("NIF: " + nif);
            System.out.println("Nombre: " + cliente.get("nombre"));
            System.out.println("Dirección: " + cliente.get("dirección"));
            System.out.println("Teléfono: " + cliente.get("teléfono"));
            System.out.println("Correo: " + cliente.get("correo"));
            System.out.println("Preferente: " + cliente.get("preferente"));
        } else {
            System.out.println("No se encontró ningún cliente con ese NIF.");
        }
        scanner.close();
    }

    public static void listarClientes() {
        System.out.println("Lista de todos los clientes:");
        for (String nif : clientes.keySet()) {
            HashMap<String, String> cliente = clientes.get(nif);
            System.out.println("NIF: " + nif);
            System.out.println("Nombre: " + cliente.get("nombre"));
            System.out.println();
        }
    }

    public static void listarClientesPreferentes() {
        System.out.println("Lista de clientes preferentes:");
        for (String nif : clientes.keySet()) {
            HashMap<String, String> cliente = clientes.get(nif);
            if (cliente.get("preferente").equalsIgnoreCase("si")) {
                System.out.println("NIF: " + nif);
                System.out.println("Nombre: " + cliente.get("nombre"));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("(1) Añadir cliente");
            System.out.println("(2) Eliminar cliente");
            System.out.println("(3) Mostrar cliente");
            System.out.println("(4) Listar todos los clientes");
            System.out.println("(5) Listar clientes preferentes");
            System.out.println("(6) Terminar");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarCliente();
                    break;
                case "2":
                    eliminarCliente();
                    break;
                case "3":
                    mostrarCliente();
                    break;
                case "4":
                    listarClientes();
                    break;
                case "5":
                    listarClientesPreferentes();
                    break;
                case "6":
                    System.out.println("Programa terminado.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}
