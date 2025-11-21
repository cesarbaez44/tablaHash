
public class TestingHashTable {

    public static void main(String[] args) {
        try {
            HashTable ht = new HashTable();

            String rutaEntrada = "C:\\archivos\\nombres.txt";
            String rutaSalida  = "C:\\archivos\\nombresHash.txt";

            // cargar nombres
            ht.cargarArchivo(rutaEntrada);

            // imprimir en consola
            System.out.println("=== TABLA HASH ===");
            ht.imprimirTabla();

            // guardar en archivo
            ht.guardarEnArchivo(rutaSalida);

            System.out.println("\nArchivo generado en: " + rutaSalida);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
