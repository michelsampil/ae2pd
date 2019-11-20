/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD.PD3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author bphoa_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        EJERCICIO 1
        Escribe, en el menor número de líneas de código posible, 
        una funcionalidad que elimine todas las entradas de un Map cuyo valor sea null.
         */
        System.out.println("EJERCICIO 1");
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("RED", "#FF0000");
        hashMap.put("BLACK", null);
        hashMap.put("BLUE", "#0000FF");
        hashMap.put("GREEN", "#008000");
        hashMap.put("WHITE", null);

        while (hashMap.values().remove(null));

        System.out.println(hashMap);
        System.out.println("-----------------------");

        /*
        EJERCICIO 2
        Escribe un método que tome como parámetro un Map<String.String> y devuelva un nuevo Map<String.String>
        en el que las claves y los valores estén intercambiados.
        Genera una excepción si hay valores duplicados en el mapa que se pasa como parámetro
         */
        System.out.println("EJERCICIO 2");
        Map<String, String> hashMapToReverse = new HashMap<>();

        hashMapToReverse.put("RED", "#FF0000");
        hashMapToReverse.put("BLACK", null);
        hashMapToReverse.put("BLUE", "#0000FF");
        hashMapToReverse.put("GREEN", "#008000");
        hashMapToReverse.put("WHITE", "#FFFFFF");
        hashMapToReverse.put("WHITE", "#FFFFFF");
        hashMapToReverse.put("WHITE", "#FFFFFF");
        System.out.println(hashMapToReverse);

        Map<String, String> hashMapReversed = new HashMap();
        for (Map.Entry<String, String> entry : hashMapToReverse.entrySet()) {
            if (entry.getValue() != null) {
                hashMapReversed.put(entry.getValue(), entry.getKey());
            }
        }
        System.out.println(hashMapReversed);
        System.out.println("-----------------------");

        /*
        EJERCICIO 3
        Escribe un programa que lea cadenas de caracteres de entrada y las imprima ordenadas según su longitud, 
        comenzando por la más corta. Si hay varias cadenas con la misma longitud, éstas deben imprimirse en orden lexicográfico.
         */
        System.out.println("Ejercicio 3");
        ArrayList<TArbolTrie> arrayTArbolTrie = new ArrayList();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src\\UT3PD\\PD3\\abc.txt");
        int palabraMasLarga = 0;
        for (String p : palabrasclave) {
            if (palabraMasLarga < p.length()) {
                palabraMasLarga = p.length();
            }
        }

        for (int i = 1; i <= palabraMasLarga; i++) {
            TArbolTrie trie = new TArbolTrie();
            arrayTArbolTrie.add(trie);
        }

        for (String p : palabrasclave) {
            int largoDePalabra = p.length();
            arrayTArbolTrie.get(largoDePalabra - 1).insertar(p);
        }
        for (int i = 1; i < palabraMasLarga; i++) {
            System.out.println("TRIES DE LARGO: " + (i));
            arrayTArbolTrie.get(i).imprimir();
            System.out.println("-------");
        }
        System.out.println("-----------------------");

        /*
        EJERCICIO 4
        Escribe un programa que lea un archivo de texto, pasado como primer parámetro en la línea de comando, 
        en una List. El programa debe luego imprimir en forma aleatoria líneas del archivo. 
        El número de líneas a imprimir será especificado como segundo parámetro. Escribe este programa 
        de forma tal que asigne una colección del tamaño correcto desde el inicio, y no una que vaya expandiéndose 
        gradualmente a medida que el archive es leído. Para calcular la cantidad de líneas del archive se puede usar
        la función java.io.File.length para obtener el tamaño del archivo y luego dividir por el tamaño considerado de una línea promedio….
         */
        System.out.println("Ejercicio 4");
        lineasAleatorias("src\\UT3PD\\PD3\\abc.txt", 5);
        System.out.println("-----------------------");

        /*
        EJERCICIOS DEL DOCUMENTO IBM JAVA COLLECTIONS FRAMEWORK
        Utilizando el documento disponible en la webasignatura “IBM JAVA COLLECTIONS FRAMEWORK”,
        se recomienda realizar los siguientes ejercicios, que son todas implementaciones muy utilizadas habitualmente en programas reales:
         */
        System.out.println("Ejercicio 1");
        System.out.println("------------------------");

        /*
         Exercise 2. “How to use a TreeSet to provide a sorted JList”, pág. 38
         */
        System.out.println("Ejercicio 2");
        System.out.println("------------------------");

        /*
         Exercise 3. “How to use an ArrayList with a JComboBox” , pág. 40
         */
        System.out.println("Ejercicio 3");
        System.out.println("------------------------");

        /*
         Exercise 4. “How to use a map to count words”, pág. 41  
         */
        System.out.println("Ejercicio 4");
        Map<String, Integer> MapaPalabraFrecuencia = new HashMap<String, Integer>();
        String[] palabrasAContar = ManejadorArchivosGenerico.leerArchivo("src\\UT3PD\\PD3\\palabrasContar.txt");
        
        for (String renglon : palabrasAContar) {
            String palabra = renglon.toLowerCase();
            if (MapaPalabraFrecuencia.containsKey(palabra)) {
                int count = MapaPalabraFrecuencia.get(palabra); // get word count 
                MapaPalabraFrecuencia.put(palabra, count + 1); // override word count
            } 
            else {
                MapaPalabraFrecuencia.put(palabra, 1); // initial word count to 1
            }
        }
        //display the data
        Set< String> keys = MapaPalabraFrecuencia.keySet(); // list of unique words because it's a Set
        TreeSet< String> sortedKeys = new TreeSet<>(keys); // ascending order of words
        for (String str : sortedKeys) {
            System.out.println("palabra =" + str + " se encuentra = " + MapaPalabraFrecuencia.get(str));
        }   
        System.out.println ("------------------------");    
    }

    /**
     *
     * @param path
     * @param cantidadDeLineas
     * @return
     */
    public static String[] lineasAleatorias(String path, int cantidadDeLineas) {
        String[] lineasSeleccionadas = new String[cantidadDeLineas];
        String[] LineasDeTexto = ManejadorArchivosGenerico.leerArchivo("src\\UT3PD\\PD3\\abc.txt");

        for (int i = 0; i < cantidadDeLineas; i++) {
            Random rand = new Random();
            int randomLine = rand.nextInt(LineasDeTexto.length);
            lineasSeleccionadas[i] = LineasDeTexto[randomLine];
            System.out.println("Linea al azar " + (i + 1) + " " + lineasSeleccionadas[i]);
        }
        return (lineasSeleccionadas);
    }

    public static Map<String, String> reverseAHashMap(HashMap<String, String> hashToReverse) {
        Map<String, String> hashMapReversed = new HashMap();
        for (Map.Entry<String, String> entry : hashToReverse.entrySet()) {
            if (entry.getValue() != null) {
                hashMapReversed.put(entry.getValue(), entry.getKey());
            }
        }
        return hashMapReversed;
    }

}
