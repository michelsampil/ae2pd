/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT3PD.TA6;

//import TrieSufijos.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author estudiante.fit
 */
public class TNodoSufijos {

    private HashMap<String, TNodoSufijos> hijos;
    private boolean esPalabra;
    private int[] locacion;

    public TNodoSufijos() {
        this.hijos = new HashMap<>();
        this.esPalabra = false;
    }

    public void insertar(String unaPalabra, int[] indices) {

        TNodoSufijos nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {

            if (!nodo.hijos.containsKey(String.valueOf(unaPalabra.charAt(c)))) {
                nodo.hijos.put(String.valueOf(unaPalabra.charAt(c)), new TNodoSufijos());
            }
            nodo = nodo.hijos.get(String.valueOf(unaPalabra.charAt(c)));
        }
        nodo.esPalabra = true;
        nodo.locacion = indices;
    }

    private void imprimir(String s, TNodoSufijos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            Set<String> set = nodo.hijos.keySet();
            for (String key : set) {
                if (nodo.hijos.get(key) != null) {
                    imprimir(s + key, nodo.hijos.get(key));
                }
            }
        }
    }

    public void imprimir() {

        imprimir("", this);
    }

    private void buscarIntervalos(LinkedList<int[]> indices, TNodoSufijos nodo) {
        if (nodo.esPalabra) {
            indices.add(nodo.locacion);
        }
        for (Map.Entry<String, TNodoSufijos> entry : nodo.hijos.entrySet()) {
            buscarIntervalos(indices,entry.getValue());
        }
    }

    public LinkedList<int[]> buscar(String s) {
        TNodoSufijos nodo = this;
        for (int c = 0; c < s.length(); c++) {
            String caracter = String.valueOf(s.charAt(c));
            if (nodo.hijos.containsKey(caracter)) {
                nodo = nodo.hijos.get(caracter);
            } else {
                return null;
            }
        }
        LinkedList<int[]> indices = new LinkedList<>();
        buscarIntervalos(indices, nodo);
        return indices;
    }

    private TNodoSufijos buscarNodoTrie(String s) {
        TNodoSufijos nodo = this;
        for (int c = 0; c < s.length(); c++) {
            if (nodo.hijos.get(String.valueOf(s.charAt(c))) == null) {
                return null;
            }
            nodo = nodo.hijos.get(String.valueOf(s.charAt(c)));
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoSufijos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
           
                palabras.add(prefijo + s);
            }
            Set<String> set = nodo.hijos.keySet();
            for (String i : set) {
                predecir(s + i, prefijo, palabras, nodo.hijos.get(i));

            }
        }
    }

    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoSufijos nodo = buscarNodoTrie(prefijo);

        if (nodo != null) {
            predecir("", prefijo, palabras, nodo);
        }
    }

}
