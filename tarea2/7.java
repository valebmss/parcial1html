import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Compra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> cesta = new HashMap<>();

        while (true) {
            System.out.print("Ingrese el articulo: ");
            String articulo = scanner.nextLine().trim();
            
            System.out.print("Ingrese el precio: ");
            double precio = Double.parseDouble(scanner.nextLine().trim());
            
            cesta.put(articulo, precio);
            
            System.out.print("Desea continuar? (S/n): ");
            String continuar = scanner.nextLine().trim().toLowerCase();
            if (!continuar.equals("s")) {
                break;
            }
        }

        System.out.println("\nFactura");
        System.out.println("-".repeat(30));
        System.out.printf("%-15s %-10s\n", "Articulo", "Precio");
        System.out.println("-".repeat(30));

        double total = 0;
        for (Map.Entry<String, Double> entry : cesta.entrySet()) {
            String articulo = entry.getKey();
            double precio = entry.getValue();
            System.out.printf("%-15s %-10.2f\n", articulo, precio);
            total += precio;
        }

        System.out.println("-".repeat(30));
        System.out.printf("%-15s %-10.2f\n", "Costo total:", total);

        scanner.close();
    }
}
