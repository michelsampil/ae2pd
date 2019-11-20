/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT3PD.TA6;

import java.util.LinkedList;

/**
 *
 * @author estudiante.fit
 */
public class TArbolSufijos {

    private TNodoSufijos raiz;
    private String[] sufijos;
    private String cadena;

    public TArbolSufijos(String cadena) {
        this.sufijos = new String[cadena.length()];
        this.cadena = cadena;
        raiz = new TNodoSufijos();
        this.crearTrie();
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public void crearTrie() {
        int[] indicesCadena = {0, cadena.length()};
        raiz.insertar(cadena, indicesCadena);
        for (int i = 0; i < cadena.length(); i++) {
            String sufijo = cadena.substring(i, cadena.length());
            sufijos[i] = sufijo;
            int[] indices = {i, cadena.length() - 1};
            raiz.insertar(sufijo, indices);
        }
    }

    public LinkedList<int[]> buscar(String s) {
        if (raiz != null) {
            return raiz.buscar(s);
        } else {
            return null;
        }
    }

    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz == null) {
            return null;
        }
        raiz.predecir(prefijo, palabras);
        return palabras;
    }

    public TNodoSufijos getRaiz() {
        return raiz;
    }

    public String[] getSufijos() {
        return sufijos;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

}
