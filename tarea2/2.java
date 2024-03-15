import java.util.HashMap;
import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) {
        HashMap<String, String> informacion = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        informacion.put("nombre", scanner.nextLine().trim());

        System.out.print("Edad: ");
        informacion.put("edad", scanner.nextLine().trim());

        System.out.print("Telefono: ");
        informacion.put("telefono", scanner.nextLine().trim());

        System.out.print("Direccion: ");
        informacion.put("direccion", scanner.nextLine().trim());

        System.out.printf("%s tiene %s años, vive en %s y su numero de telefono es %s\n",
                informacion.get("nombre"),
                informacion.get("edad"),
                informacion.get("direccion"),
                informacion.get("telefono"));

        scanner.close();
    }
}
