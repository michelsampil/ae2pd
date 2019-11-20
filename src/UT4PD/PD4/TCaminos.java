package UT4PD.PD4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import UT4PD.PD3.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author bphoa_000
 */
public class TCaminos {
    
    private Collection<TCamino> caminos;

    public TCaminos() {
        this.caminos = new LinkedList<>();
    }
    
    public String imprimirCaminos(){
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos){
            sb.append(camino.imprimirEtiquetas()+ ", Costo: " +camino.getCostoTotal()+"\n");
        }
        return sb.toString();
    }

    public void imprimirCaminosConsola(){
        System.out.println(imprimirCaminos());
    }

    public Collection<TCamino> getCaminos() {
        return caminos;
    }
    
    
    
}
