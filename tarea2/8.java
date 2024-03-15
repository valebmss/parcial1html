import java.util.HashMap;
import java.util.Scanner;

public class Traductor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> traducciones = new HashMap<>();

        System.out.print("Ingrese las palabras en español e inglés separadas por dos puntos, y cada par <palabra>:<traducción> separados por comas: ");
        String[] palabras = scanner.nextLine().split(",");
        for (String palabra : palabras) {
            String[] par = palabra.split(":");
            traducciones.put(par[0].trim(), par[1].trim());
        }
        System.out.println(traducciones);
        
        System.out.print("Ingrese una frase en español: ");
        String[] frase = scanner.nextLine().split(" ");
        for (String palabra : frase) {
            if (traducciones.containsKey(palabra)) {
                System.out.print(traducciones.get(palabra) + " ");
            } else {
                System.out.print(palabra + " ");
            }
        }

        scanner.close();
    }
}
