package UT5PD.PD1;

import java.util.LinkedList;
import java.util.Map;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoNoDirigido unGrafito = UtilGrafos.cargarGrafo("src\\UT5PD\\PD1\\verticesBEA.txt", "src\\UT5PD\\PD1\\aristasBEA.txt", false, TGrafoNoDirigido.class);
        //LinkedList<TVertice> hola = (LinkedList<TVertice>) unGrafito.bea("e");
        for (TArista arista : unGrafito.Aristas) {
                        System.out.println(arista.getEtiquetaOrigen()+" "+arista.getEtDestino() +" "+arista.getCosto());
                    }
        TGrafoNoDirigido unGrafoPrim = unGrafito.Prim();
        
        
        
                for (Map.Entry<Comparable, TVertice> entry : unGrafoPrim.getVertices().entrySet()) {
            System.out.println("clave=" + entry.getKey());
            LinkedList<TAdyacencia> ady = entry.getValue().getAdyacentes();
            int cont = 0;
            for (TAdyacencia a: ady){

                cont += a.getCosto();
            }
            System.out.println(cont);
            cont = 0;
            

        } 

    }
}
