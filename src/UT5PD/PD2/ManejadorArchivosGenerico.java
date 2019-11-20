package UT5PD.PD2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManejadorArchivosGenerico {

    /**
     * @param nombreCompletoArchivo
     * @param listaLineasArchivo lista con las lineas del archivo
     */
    public static void escribirArchivo(String nombreCompletoArchivo,
            String[] listaLineasArchivo) {
        FileWriter fw;
        try {
            fw = new FileWriter(nombreCompletoArchivo, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (String lineaActual : listaLineasArchivo) {
                    bw.write(lineaActual);
                    bw.newLine();
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "
                    + nombreCompletoArchivo);
        }
    }

    public static String[] leerArchivoRutaRelativa(String nombreCompletoArchivo, boolean ignoreHeader) {
        String path = ManejadorArchivosGenerico.class.getResource(nombreCompletoArchivo).getPath();
        return leerArchivo(path, ignoreHeader);
    }

    public static String[] leerArchivo(String nombreCompletoArchivo, boolean ignoreHeader) {
        FileReader fr;
        ArrayList<String> listaLineasArchivo = new ArrayList<>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            try (BufferedReader br = new BufferedReader(fr)) {
                String lineaActual = br.readLine();
                if (ignoreHeader) {
                    lineaActual = br.readLine();
                }
                while (lineaActual != null) {
                    listaLineasArchivo.add(lineaActual);
                    lineaActual = br.readLine();
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
        }
        //System.out.println("Archivo leido satisfactoriamente");

        return listaLineasArchivo.toArray(new String[0]);
    }
}