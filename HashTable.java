import java.io.*;
import java.util.*;

public class HashTable {

    private LinkedList<String>[] tabla;
    private final int TAMANO = 10;

    public HashTable() {
        tabla = new LinkedList[TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    
    // Hash basado en suma de caracteres
    private int hash(String nombre) {
        int suma = 0;
        for (char c : nombre.toCharArray()) {
            suma += c;
        }
        return suma % TAMANO;
    }

    public void insertar(String nombre) {
        int index = hash(nombre);
        tabla[index].add(nombre);
    }

    public void imprimirTabla() {
        for (int i = 0; i < TAMANO; i++) {
            System.out.println(i + ": " + tabla[i]);
        }
    }

    // Guarda la tabla en archivo
    public void guardarEnArchivo(String ruta) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(ruta));

        for (int i = 0; i < TAMANO; i++) {
            pw.println(i + ": " + tabla[i].toString());
        }

        pw.close();
    }

    // Carga los nombres desde archivo
    public void cargarArchivo(String ruta) throws IOException {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            System.out.println("No existe el archivo: " + ruta);
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (!linea.isEmpty()) {
                insertar(linea);
            }
        }

        br.close();
    }
}
