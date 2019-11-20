/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD.PD4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

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
        Map< String, Integer> mapaPalabraOcurrencias = new HashMap<>();
        String[] renglones = ManejadorArchivosGenerico.leerArchivo("src\\UT3PD\\PD4\\libro.txt");

        for (String renglon : renglones) {
            String renglonLimpio = renglon.toLowerCase();
            String[] palabras = renglonLimpio.split(" ");
            for (String palabra : palabras) {
                String palabraLimpia = palabra.replaceAll("[^a-zA-Z0-9']", "");//regular expresion to sanetize the string

                /*
                Si estaba en espanol...
                 resultado=texto.replaceAll("[^\\dA-Za-z áéíóúñÑ]", "");// ^=negado \\
                 d=dígitos de 0 a 9 
                 s-z y A-Z =(rangos de a a z en mayúsculas y minúsculas) y después está la lista con tildes y las ñ y Ñ              
                 */
                if (mapaPalabraOcurrencias.containsKey(palabraLimpia)) {
                    int count = mapaPalabraOcurrencias.get(palabraLimpia); // get word count 
                    mapaPalabraOcurrencias.put(palabraLimpia, count + 1); // override word count
                } else {
                    mapaPalabraOcurrencias.put(palabraLimpia, 1); // initial word count to 1
                }
            }

        }
        //display the data
        Set< String> keys = mapaPalabraOcurrencias.keySet(); // list of unique words because it's a Set
        TreeSet< String> sortedKeys = new TreeSet<>(keys); // ascending order of words
        for (String str : sortedKeys) {
            System.out.println("Palabra: " + str + " se encuentra " + mapaPalabraOcurrencias.get(str));
        }

        System.out.println("****EXPERIMENTO los 10 mejores******");
        Map<Integer, String> hashMapReversed = new HashMap();
        /*for (Map.Entry<String, Integer> entry : mapaPalabraOcurrencias.entrySet()) {
            if (entry.getValue() != null) {
                hashMapReversed.put(entry.getValue(), entry.getKey());
            }
        }*/

        for (String str : sortedKeys) {
            hashMapReversed.put(mapaPalabraOcurrencias.get(str), str);
        }
        //List<String> collect = hashMapReversed.keySet().stream().sorted().collect(Collectors.toList());
        //System.out.println(collect);
        

        int n = 5;
        List<Entry<String, Integer>> greatest = findGreatest(mapaPalabraOcurrencias, mapaPalabraOcurrencias.size());
        System.out.println("Top "+n+" Palabras mas ocurridas:");
        for (Entry<String, Integer> entry : greatest)
        {
            System.out.println(entry);
        }
    }

    private static <K, V extends Comparable<? super V>> List<Entry<K, V>> 
        findGreatest(Map<K, V> mapaPalabraOcurrencias, int n)
    {
        Comparator<? super Entry<K, V>> comparator = 
            new Comparator<Entry<K, V>>()
        {
            @Override
            public int compare(Entry<K, V> e0, Entry<K, V> e1)
            {
                V v0 = e0.getValue();
                V v1 = e1.getValue();
                return v0.compareTo(v1);
            }
        };
        PriorityQueue<Entry<K, V>> highest = 
            new PriorityQueue<Entry<K,V>>(n, comparator);
        for (Entry<K, V> entry : mapaPalabraOcurrencias.entrySet())
        {
            highest.offer(entry);
            while (highest.size() > n)
            {
                highest.poll();
            }
        }

        List<Entry<K, V>> result = new ArrayList<Map.Entry<K,V>>();
        while (highest.size() > 0)
        {
            result.add(highest.poll());
        }
        return result;
    }

}
