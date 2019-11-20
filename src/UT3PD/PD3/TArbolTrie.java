package UT3PD.PD3;

import UT3PD.PD1.*;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        int resultado = 0;
        if (raiz != null) {
            resultado = raiz.buscar(palabra);
        }
        return resultado;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> lista = new LinkedList<>();
        if (raiz != null) {
            this.raiz.predecir(prefijo, lista);
        }
        return lista;
    }

}
