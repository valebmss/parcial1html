import java.util.HashMap;
import java.util.Scanner;

public class Repuestos {

    public static void main(String[] args) {
        HashMap<String, Double> repuestos = new HashMap<>();
        repuestos.put("Bujia", 1.40);
        repuestos.put("Pastillas de freno", 5.80);
        repuestos.put("Radiador", 300.50);
        repuestos.put("Rodamiento", 10.70);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el repuesto que desea comprar: ");
        String inputRepuesto = scanner.nextLine().trim().toLowerCase();

        System.out.print("Ingrese la cantidad que desea comprar: ");
        int inputCantidad = Integer.parseInt(scanner.nextLine().trim());

        if (repuestos.containsKey(inputRepuesto)) {
            double resultado = repuestos.get(inputRepuesto) * inputCantidad;
            System.out.printf("El precio total de la compra es: %.2f dolares\n", resultado);
        } else {
            System.out.println("El repuesto ingresado no es valido");
        }

        scanner.close();
    }
}
