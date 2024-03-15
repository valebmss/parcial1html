import java.util.HashMap;
import java.util.Scanner;

public class ConvertirDivisa {

    public static void main(String[] args) {
        HashMap<String, Double> divisas = new HashMap<>();
        divisas.put("Dolar", 3927.0);
        divisas.put("Euro", 4255.0);
        divisas.put("Yen", 26.12);
        divisas.put("Libra", 4987.0);
        divisas.put("Peso Mexicano", 230.08);
        divisas.put("Bitcoin", 200284458.0);
        divisas.put("Yuan", 545.79);
        divisas.put("Etherum", 11531560.0);
        divisas.put("Franco", 4469.0);
        divisas.put("Sol", 1039.0);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la divisa a la que desea convertir: ");
        String inputDivisa = scanner.nextLine().trim();
        System.out.print("Ingrese la cantidad de pesos colombianos a convertir: ");
        double inputCantidad = Double.parseDouble(scanner.nextLine().trim());

        System.out.printf("La taza de cambio de %s es: %.2f %s por 1 peso colombiano (COP)\n", inputDivisa, divisas.get(inputDivisa), inputDivisa);

        if (divisas.containsKey(inputDivisa)) {
            double resultado = inputCantidad / divisas.get(inputDivisa);
            System.out.printf("El resultado de la conversion es: %.2f %s\n", resultado, inputDivisa);
        } else {
            System.out.println("La divisa ingresada no es valida");
        }

        scanner.close();
    }
}
