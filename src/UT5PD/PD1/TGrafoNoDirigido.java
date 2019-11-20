package UT5PD.PD1;

import java.util.Collection;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    public TListaAristas Aristas;

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristasInsertar) {
        super(vertices, aristasInsertar);
        
        //this.Aristas.addAll(aristasInsertar);
        /*
        for (TVertice vertice : vertices) {      
            for (Object ady : vertice.getAdyacentes()) {
                laArista = new TArista(ady.);
                Aristas.
            }
            Aristas.addAll(vertice.getAdyacentes());
        }
        */
        // TODO Auto-generated constructor stub
    }

    public void cargarArista(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Comparable costo) {
        Aristas.add(new TArista(etiquetaOrigen, etiquetaDestino, (double) costo));

        insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo);
    }

    // este procedimiento de PRIM usa la lista de aristas expl�cita para
    // resolver. Por claridad y seguridad, se arman listas de v�rtices para
    // trabajar,
    // "VerticesU" y "VerticesV", de forma de hacerlo lo m�s parecido posible al
    // seudoc�digo abstracto.
    // al final devuelve un nuevo grafo no dirigido que es el �rbol abarcador de
    // costo m�nimo obtenido.
    public TGrafoNoDirigido Prim() {
        // devuelve un nuevo grafo, que es el Arbol Abarcador de Costo M�nimo
        int costoPrim = 0;
        LinkedList<TVertice> VerticesU = new LinkedList<>();
        LinkedList<TVertice> VerticesV = new LinkedList<>();
        TListaAristas AristasAAM = new TListaAristas();
        TArista tempArista;

        if (vertices.isEmpty()) {
            return null;
        }

        // armar la lista VerticesV de trabajo - vertices.keySet???
        //  VerticesV
        //VerticesV.addAll((Collection<? extends Comparable>) vertices);
        VerticesV.addAll(this.vertices.values());
        //---------COMPLETAR ALGORITMO--------

        // pasar el primero de V a U
        // sacar de VerticesV y agregarlo a VerticesU
        VerticesU.add(VerticesV.getFirst());
        VerticesV.remove(VerticesU.getFirst());
        
        System.out.println("vertices u tiene " + VerticesU.size() + "vertices v tiene " + VerticesV.size());
        
        System.out.println("las lista de aristas son " + Aristas.size() );

        boolean vaciaV = VerticesV.isEmpty();
        while (!vaciaV) {
            // elegir una arista de costo minimo que vaya de U a V, agregarla a
            TArista a = this.Aristas.buscarMin(VerticesU, VerticesV);      
            // la lista de aristas del AAM, quitar el v�rtice v de V y agregarlo
            // a U
            //---------COMPLETAR ALGORITMO--------
            // invocando al m�todo correspondiente de TListaAristas Aristas
            if (a==null) {
                System.out.println("es nulo");
            }
            if(a!=null){
                AristasAAM.add(a);
                VerticesU.add(vertices.get(a));
                VerticesV.remove(a.getEtiquetaDestino());
                costoPrim+=a.getCosto();
                System.out.println("vertices v son: " + VerticesV.size());
            }

        }

        System.out.println("costo AAM: " + costoPrim);

        //A partir de los vertices del grafo (Vertices.Values????)  las aristas en AristasAAM armar el grafo nuevoGrafo y retornarlo
        TGrafoNoDirigido nuevoGrafo = new TGrafoNoDirigido(this.getVertices().values(), AristasAAM);

        //---------COMPLETAR ALGORITMO--------
        // crear nuevoGrafo 
        return nuevoGrafo;
    }

    @SuppressWarnings("rawtypes")
    public boolean insertarAdyacencia(Comparable etiquetaOrigen, Comparable etiquetaDestino, Comparable costo) {
        return (super.insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo) && super.insertarAdyacencia(etiquetaDestino, etiquetaOrigen, costo));
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
