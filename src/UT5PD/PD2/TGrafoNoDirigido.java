package UT5PD.PD2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    /**
     *
     * @return
     */
    @Override
    public TGrafoNoDirigido Prim() {
        // devuelve un nuevo grafo, que es el Arbol Abarcador de Costo M�nimo
        int costoPrim = 0;
        Collection<Comparable> VerticesU = new LinkedList<>();
        Collection<Comparable> VerticesV = new LinkedList<>();
        TAristas AristasAAM = new TAristas();
        TArista tempArista;

        if (this.getVertices().isEmpty()) {
            return null;
        }

        // armar la lista VerticesV de trabajo - vertices.keySet???
        //  VerticesV
        //VerticesV.addAll((Collection<? extends Comparable>) vertices);
        LinkedList todosLosVertices = new LinkedList (this.getVertices().keySet());
        VerticesV.addAll(todosLosVertices);
        //---------COMPLETAR ALGORITMO--------

        // pasar el primero de V a U
        // sacar de VerticesV y agregarlo a VerticesU
        VerticesU.add((Comparable) VerticesV.toArray()[0]);
        VerticesV.remove((Comparable) VerticesV.toArray()[0]);
        
        System.out.println("vertices u tiene " + VerticesU.size() + "vertices v tiene " + VerticesV.size());
        
        System.out.println("las lista de aristas son " + lasAristas.size() );

        boolean vaciaV = VerticesV.isEmpty();
        while (!vaciaV) {
            // elegir una arista de costo minimo que vaya de U a V, agregarla a
            TArista a = this.lasAristas.buscarMin(VerticesU, VerticesV);      
            // la lista de aristas del AAM, quitar el v�rtice v de V y agregarlo
            // a U
            //---------COMPLETAR ALGORITMO--------
            // invocando al m�todo correspondiente de TListaAristas Aristas
            if (a==null) {
                System.out.println("es nulo");
            }
            if(a!=null){
                AristasAAM.add(a);
                VerticesU.add((Comparable) this.getVertices().get(a.etiquetaDestino));
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

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        TVertice vertice = this.getVertices().get(etiquetaOrigen);

        if (vertice != null) {
            vertice.bea(visitados);
        }
        return visitados;
    }

    public void numerar() {
        this.desvisitarVertices();
        TArista arista = this.lasAristas.peek();
        TVertice vertice = this.getVertices().get(arista.getEtiquetaOrigen());
        if (vertice != null) {
            vertice.numerar(0, vertice);
        } else {
            System.out.println("no existe el vertice");
        }
    }

    public Collection<TVertice> puntosDeArticulacion() {
        LinkedList<TVertice> puntosArticulacion = new LinkedList<>();
        this.desvisitarVertices();
        Comparable unaEtiquetaDeNodo = this.lasAristas.getFirst().getEtiquetaOrigen();
        TVertice vertice = this.getVertices().get(unaEtiquetaDeNodo);
        vertice.numerar(1, vertice);
        
        puntosArticulacion = vertice.puntosDeArticulacion();
        System.out.println(puntosArticulacion.size());
        return puntosArticulacion;
    }
    
    /**
     *
     * @return
     */
    @Override
    public TGrafoNoDirigido Kruskal() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TAristas misAristas = this.lasAristas;
        LinkedList<TArista> AAbarcadorAristas = new LinkedList<>();
        Collection<Comparable> todosVertices = this.getVertices().keySet();
        LinkedList<TVertice> AAbarcadorVertices = new LinkedList<>();

        while (!AAbarcadorVertices.containsAll(todosVertices)) {
            try {
                TArista ar = misAristas.buscarMin(todosVertices, todosVertices);
                
                if (!AAbarcadorVertices.contains(this.getVertices().get(ar.etiquetaDestino))) {
                    AAbarcadorVertices.add(this.getVertices().get(ar.etiquetaDestino));
                    AAbarcadorVertices.add(this.getVertices().get(ar.etiquetaOrigen));
                    AAbarcadorAristas.add(ar);
                    TArista revAr = new TArista(ar.etiquetaDestino,ar.etiquetaOrigen,ar.costo);                    
                    misAristas.remove(ar);
                    misAristas.remove(revAr);
                }
                TArista revAr = new TArista(ar.etiquetaDestino,ar.etiquetaOrigen,ar.costo);
                misAristas.remove(ar);
                misAristas.remove(revAr);
            } catch (Exception e) {
                //System.out.println(e);
                break;
            }
        }
        return new TGrafoNoDirigido(AAbarcadorVertices,AAbarcadorAristas); 
    }




    public Object getCostoPrim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
