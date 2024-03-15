import java.util.HashMap;
import java.util.Scanner;

public class Fecha {

    public static void main(String[] args) {
        HashMap<Integer, String> meses = new HashMap<>();
        meses.put(1, "Enero");
        meses.put(2, "Febrero");
        meses.put(3, "Marzo");
        meses.put(4, "Abril");
        meses.put(5, "Mayo");
        meses.put(6, "Junio");
        meses.put(7, "Julio");
        meses.put(8, "Agosto");
        meses.put(9, "Septiembre");
        meses.put(10, "Octubre");
        meses.put(11, "Noviembre");
        meses.put(12, "Diciembre");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la fecha en formato dd/mm/aaaa: ");
        String inputFecha = scanner.nextLine().trim();

        String[] partesFecha = inputFecha.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);

        System.out.printf("La fecha ingresada es: %d de %s del %d\n", dia, meses.get(mes), anio);

        scanner.close();
    }
}
