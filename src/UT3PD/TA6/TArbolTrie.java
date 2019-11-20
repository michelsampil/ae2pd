/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD.TA6;

import java.util.LinkedList;

/**
 *
 * @author estudiante.fit
 */
public class TArbolTrie {
    
     private TNodoTrie raiz;
             
     public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
   
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> lista = new LinkedList<>();
        if (raiz != null) {
            this.raiz.predecir(prefijo, lista);
        }
        return lista;
    }
}
