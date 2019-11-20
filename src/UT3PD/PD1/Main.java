package UT3PD.PD1;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src\\UT3PD\\PD1\\abc.txt");
        for (String p : palabrasclave) {
            trie.insertar(p);
        }
        trie.imprimir();
    }
}