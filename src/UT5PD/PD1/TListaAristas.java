package UT5PD.PD1;

import java.util.Iterator;
import java.util.LinkedList;

public class TListaAristas extends LinkedList<TArista> {

    public TArista obtenerPrimero() {
        return this.getFirst();
    }

    /*
	public TArista buscar(Comparable etOrigen, Comparable etDestino) {
		TArista tempArista;
		tempArista = (TArista) obtenerPrimero();
		while (tempArista != null) {
			if ((tempArista.getEtiquetaOrigen().compareTo(etOrigen) == 0)
					&& (tempArista.getEtDestino().compareTo(etDestino) == 0)) {
				return tempArista;
			}
			tempArista = this.
		}
		return null;
	}
     */

    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        TArista tempArista;
        for (TArista laa : this) {
            if ((laa.getEtiquetaOrigen().equals(etOrigen)) && laa.getEtiquetaDestino().equals(etDestino)) {
                return laa;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public TArista buscarMin(LinkedList<TVertice> VerticesU, LinkedList<TVertice> VerticesV) {
        TArista tempArista = null;
        TArista tAMin = null;
        Double costoMin = Double.POSITIVE_INFINITY;
        
        System.out.println("vertices u son " + VerticesU.size() + " los vertices v son " + VerticesV.size());

        for (TVertice v : VerticesV) {
            System.out.println("etiqueta " + v.getEtiqueta());
        }
        
        for (TVertice itU : VerticesU) {
            //TVertice u = (TVertice) itU.next();
            TVertice u =  itU;
            
            String toStringU = u.getEtiqueta().toString();
            System.out.println("iterando en u tiene " + u.getEtiqueta());
            
            for (TVertice itV : VerticesV) {
                //TVertice v = (TVertice) itV.next();
                TVertice v =  itV;
                
            String toStringV = u.getEtiqueta().toString();
            System.out.println("iterando en v tiene " + v.getEtiqueta());
                
                //TVertice v = (TVertice) itV.next();
                this.buscar(u.getEtiqueta(), v.getEtiqueta());
                if (tempArista !=null && tempArista.getCosto()<costoMin) {
                    System.out.println("DENTRO DEL IFFFFF");
                    tAMin=tempArista;
                    costoMin=tempArista.getCosto();
                }
            }
        }
        
        
        //---------COMPLETAR ALGORITMO--------
        // para todo u en Vertices U
        // para todo v en Vertices V
        // tA =buscar (u, v)
        // si tA <> null y tA.costo < costoMin entonces
        // tAMin = tA y costoMin = tA.costo
        // fin para todo v
        // fin para todo u
        // devolver tAMin
        //System.out.println("tAMIN tiene " + tAMin.getCosto());
        return tAMin;
    }
}
