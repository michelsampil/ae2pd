package UT5PD.PD2;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private final LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int numBp;
    private int numBajo;

    public int getNumBp() {
        return numBp;
    }

    public void setNumBp(int numBp) {
        this.numBp = numBp;
    }

    public int getNumBajo() {
        return numBajo;
    }

    public void setNumBajo(int numBajo) {
        this.numBajo = numBajo;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
       System.out.println("Vertice: " + this.getEtiqueta() + " Bajo:" + this.getNumBajo() + " - " + "Numero Bp: " + this.getNumBp());
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
        
            TVertice vertAdy = adyacente.getDestino();
          
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        visitados.add(this);
        this.setVisitado(true);
        Queue<TVertice> c = new LinkedList();
        c.add(this);
        while (c.size() > 0) {
            TVertice x = c.remove();
            for (TAdyacencia ady : (LinkedList<TAdyacencia>) x.getAdyacentes()) {
                TVertice y = ady.getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    visitados.add(y);
                    c.add(y);
                }
            }
        }
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        setVisitado(true);
        camino.add(this.getEtiqueta());
        boolean resultado = false;
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                resultado = vertAdy.tieneCiclo(camino);
                if (resultado) {
                    return resultado;
                }
            } else {
                if (camino.contains(vertAdy.etiqueta)) {
                    return true;
                }
            }
        }
        return resultado;
    }

    /**
     *
     * @param numero
     * @param padre
     */
    public void numerar(int numero, TVertice padre) {
        this.visitado = true;
        this.numBp = numero;
        this.numBajo = numero;
        for (TAdyacencia adyacente : adyacentes) {
            TVertice aux = adyacente.getDestino();
            if (!aux.visitado) {
                aux.numerar(numero + 1, this);
            }
            if (numBajo >= aux.numBajo && !aux.equals(padre)) {
                setNumBajo(aux.numBajo);
            }
        }
    }
    
    public LinkedList<TVertice> puntosDeArticulacion(){
    return null;
    }

}
