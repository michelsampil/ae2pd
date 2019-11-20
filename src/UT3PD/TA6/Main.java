/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD.TA6;

import java.util.ArrayList;

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
        String[] palabras = ManejadorArchivosGenerico.leerArchivo("src\\UT3PD\\TA6\\example.txt");
        String texto = ""; 
        for (String p : palabras) {
            texto = texto + " " + p;
        }
        System.out.println("");
        System.out.println(texto);      
        TArbolSufijos trie = new TArbolSufijos(texto);
        
        System.out.println("");
        System.out.println("**Chequeando patron de ocurrencia en el trie***");
        System.out.println("");
        System.out.println("duchan esta: " + trie.predecir("duchan").size());
        System.out.println("hola esta: " + trie.predecir("hola").size());
        System.out.println("ducho  esta: " + trie.predecir("ducho").size());
        System.out.println("ducho!  esta: " + trie.predecir("ducho!").size());
        System.out.println("papa  esta: " + trie.predecir("papa").size());
        System.out.println("HOla  esta: " + trie.predecir("HOla").size());
        
        System.out.println("");
        System.out.println("***SABE***");
        //Object[] array = trie.predecir((texto).toArray());
    }
    
}
