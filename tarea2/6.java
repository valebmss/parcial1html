import java.util.HashMap;
import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) {
        HashMap<String, String> informacion = new HashMap<>();
        String[] campos = {"nombre", "apellido", "edad", "sexo", "telefono", "correo"};
        Scanner scanner = new Scanner(System.in);

        for (String campo : campos) {
            System.out.print("Ingrese su " + campo + ": ");
            String valor = scanner.nextLine().trim();
            informacion.put(campo, valor);
            System.out.println(informacion);
        }

        scanner.close();
    }
}
