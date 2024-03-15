import java.util.HashMap;

public class DirectorioClientes {

    public static void main(String[] args) {
        String directorio = "cedula;nombre;email;telefono;descuento\n1001234567L;LuisGonzález;luisgonzalez@mail.com;656343576;12.5\n1014737846;ValeriaLarrea;leidyvale244z@gmail.com;3158812329;10";

        String[] lineas = directorio.strip().split("\n");
        String[] campos = lineas[0].split(";");

        HashMap<String, HashMap<String, String>> clientes = new HashMap<>();

        for (int i = 1; i < lineas.length; i++) {
            String[] valores = lineas[i].split(";");
            HashMap<String, String> cliente = new HashMap<>();
            for (int j = 0; j < campos.length; j++) {
                cliente.put(campos[j], valores[j]);
            }
            clientes.put(valores[0], cliente);
        }

        System.out.println(clientes);
    }
}
