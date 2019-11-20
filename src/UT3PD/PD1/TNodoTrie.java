package UT3PD.PD1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class TNodoTrie implements INodoTrie {

    //private char letra;
    private HashMap<String, TNodoTrie> hijosHash;
    private boolean esPalabra;

    public TNodoTrie() {
        //letra = ' ';
        hijosHash =new HashMap();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            String letra = Character.toString(unaPalabra.charAt(c));
            if (!nodo.hijosHash.containsKey(letra)) {
                TNodoTrie nuevoNodo = new TNodoTrie();
                nodo.hijosHash.put(letra, nuevoNodo);
            }
            nodo = nodo.hijosHash.get(letra);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            if (nodo.hijosHash.entrySet()!=null) {
                Set <String> claves = nodo.hijosHash.keySet();
                for (String c : claves){
                    this.imprimir(s + c, nodo.hijosHash.get(c));               
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            String letra = Character.toString(s.charAt(c));
            if (nodo.hijosHash.entrySet() == null) {
                return null;
            }
            nodo = nodo.hijosHash.get(letra);
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        /*if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {

                    predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }*/
        
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);

            }
            if (nodo.hijosHash.entrySet()!=null) {
                Set <String> claves = nodo.hijosHash.keySet();
                for (String c : claves){
                    this.predecir(s, s + c, palabras, nodo.hijosHash.get(c));               
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = this.buscarNodoTrie(prefijo);
        if (nodo != null) {
            this.predecir("", prefijo, palabras, nodo);
        }
    }

    @Override
    public int buscar(String s) {
        int comparaciones = 0;
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            String indice = Character.toString(s.charAt(c));
            comparaciones++;
            if (nodo.hijosHash.entrySet() == null) {
                return 0;
            }
            nodo = nodo.hijosHash.get(indice);
        }
        return comparaciones;
    }
}
