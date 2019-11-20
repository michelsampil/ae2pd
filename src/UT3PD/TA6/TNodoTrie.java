/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD.TA6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author estudiante.fit
 */
public class TNodoTrie {

    private HashMap<Comparable,TNodoTrie> hijos;
    public boolean esPalabra;
    
     public TNodoTrie() {
        this.hijos = new HashMap<>();
        this.esPalabra = false;
    }
     
    public void insertar(String palabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            if (!nodo.hijos.containsKey(String.valueOf(palabra.charAt(c)))) {
            
                nodo.hijos.put(String.valueOf(palabra.charAt(c)), new TNodoTrie());
            }
            nodo = nodo.hijos.get(String.valueOf(palabra.charAt(c)));
        }
        nodo.esPalabra = true;
    }
    
    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            Set<Comparable> c = nodo.hijos.keySet();
            for (Comparable z : c){
                this.imprimir(s + z, nodo.hijos.get(z));
            }           
        }
    }
    public void imprimir() {
        imprimir("", this);
    }
    
    public TNodoTrie buscarNodoTrie(String palabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            
            if (!nodo.hijos.containsKey(String.valueOf(palabra.charAt(c)))) {
                return null;
            }
            
            nodo = nodo.hijos.get(String.valueOf(palabra.charAt(c)));
        }
        return nodo;
    }
    
 
    
    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);

            }
             Set<Comparable> c = nodo.hijos.keySet();
            for (Comparable z : c){
                predecir(s + z, prefijo, palabras, nodo.hijos.get(z));
            }    
          
        }
    }

    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = this.buscarNodoTrie(prefijo);
        if (nodo != null) {
            this.predecir("", prefijo, palabras, nodo);
            String[] yi = new String[palabras.size()];
            palabras.toArray(yi);
            palabras.clear();
            Arrays.sort(yi);
            for (String a : yi){
                palabras.add(a);
            }
        }
    }
    
}
