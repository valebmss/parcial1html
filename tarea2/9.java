import java.util.HashMap;
import java.util.Scanner;

public class Facturas {

    static HashMap<String, Double> facturas = new HashMap<>();
    static double cobro = 0;

    public static void mostrarEstadoCobro() {
        double totalCobrado = cobro;
        double totalPendiente = facturas.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Cantidad cobrada hasta el momento: " + totalCobrado);
        System.out.println("Cantidad pendiente de cobro: " + totalPendiente);
    }

    public static void añadirFactura() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de factura: ");
        String numeroFactura = scanner.nextLine();
        System.out.print("Ingrese el coste de la factura: ");
        double costeFactura = Double.parseDouble(scanner.nextLine());
        facturas.put(numeroFactura, costeFactura);
        System.out.println("Factura añadida correctamente.");
        scanner.close();
    }

    public static void pagarFactura() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de factura a pagar: ");
        String numeroFactura = scanner.nextLine();
        if (facturas.containsKey(numeroFactura)) {
            cobro += facturas.get(numeroFactura);
            facturas.remove(numeroFactura);
            System.out.println("Factura pagada correctamente.");
        } else {
            System.out.println("La factura no existe.");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Añadir factura");
            System.out.println("2. Pagar factura");
            System.out.println("3. Terminar");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    añadirFactura();
                    mostrarEstadoCobro();
                    break;
                case "2":
                    pagarFactura();
                    mostrarEstadoCobro();
                    break;
                case "3":
                    scanner.close();
                    System.out.println("Programa terminado.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}
