import java.util.HashMap;
import java.util.Map;

public class CreditosMaterias {

    public static void main(String[] args) {
        HashMap<String, Integer> materias = new HashMap<>();
        materias.put("Matematicas", 4);
        materias.put("Programacion", 3);
        materias.put("Base de datos", 3);
        materias.put("Fisica", 4);
        materias.put("Quimica", 3);
        materias.put("Biologia", 3);
        materias.put("Ingles", 2);
        materias.put("Historia", 2);
        materias.put("Filosofia", 2);
        materias.put("Educacion fisica", 2);
        materias.put("Arte", 2);
        materias.put("Geografia", 2);

        for (Map.Entry<String, Integer> entry : materias.entrySet()) {
            System.out.println(entry.getKey() + " tiene " + entry.getValue() + " creditos");
        }

        int totalCreditos = 0;
        for (int creditos : materias.values()) {
            totalCreditos += creditos;
        }
        System.out.println("El total de creditos es: " + totalCreditos);
    }
}
