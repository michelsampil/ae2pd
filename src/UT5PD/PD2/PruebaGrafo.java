package UT5PD.PD2;

import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoNoDirigido unGrafito = UtilGrafos.cargarGrafo("src\\UT5PD\\PD2\\verticesBEA.txt", "src\\UT5PD\\PD2\\aristasBEA.txt", false, TGrafoNoDirigido.class);
        TGrafoNoDirigido AACM = unGrafito.Kruskal();
        
        System.out.println("***Kruskal ***");
        for (TArista arista : AACM.lasAristas) {
            System.out.println(arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto());
        }
        System.out.println("FIN Kruskal");
        
        System.out.println("***Prim***");
        TGrafoNoDirigido AACMprim = unGrafito.Prim();
                System.out.println("***Kruskal ***");
        for (TArista arista : AACMprim.lasAristas) {
            System.out.println(arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto());
        }
        System.out.println("***FIN Kruskal***");
        
      }
        
    }

