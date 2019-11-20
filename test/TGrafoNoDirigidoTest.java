
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import UT5PD.PD2.TArista;
import UT5PD.PD2.TGrafoDirigido;
import UT5PD.PD2.TGrafoNoDirigido;
import UT5PD.PD2.TVertice;


/**
 *
 * @author bphoa_000
 */
public class TGrafoNoDirigidoTest {
    
    private static TGrafoNoDirigido gnd;
    private static TGrafoDirigido gd;
    
    public TGrafoNoDirigidoTest() {
    }
    
    
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Grafo no dirigido");
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        TVertice v4 = new TVertice("D");
        
//        TVertice v5 = new TVertice("E");
//        TVertice v6 = new TVertice("F");
        
        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        
//        vertices.add(v5);
//        vertices.add(v6);
        
        TArista a1 = new TArista("A", "B", 20);
        TArista a2 = new TArista("A", "C", 10);
        TArista a3 = new TArista("B", "C", 40);
        TArista a4 = new TArista("C", "D", 50);
        
//        TArista a5 = new TArista("D", "E", 3);
//        TArista a6 = new TArista("A", "F", 8);
        
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        
//        aristas.add(a5);
//        aristas.add(a6);
        
        gnd = new TGrafoNoDirigido(vertices, aristas);
        
    }
    
    @BeforeClass
    public static void beforeClass2(){
        System.out.println("Grafo Dirigido");
        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        TVertice v4 = new TVertice("D");
        
        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        
        TArista a1 = new TArista("A", "C", 10);
        TArista a2 = new TArista("B", "A", 20);
        TArista a3 = new TArista("C", "B", 40);
        TArista a4 = new TArista("C", "D", 50);
                
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        
        
        gd = new TGrafoDirigido(vertices, aristas);
        
    }
    
    @Test
    public void TestBea(){
        System.out.println("TestBea");
        Collection<TVertice> bea = gnd.bea("A");
        
        LinkedList<Comparable> vertices = new LinkedList<>();
        LinkedList<Comparable> verticesEsperado = new LinkedList<>();
        verticesEsperado.add("A");
        verticesEsperado.add("B");
        verticesEsperado.add("C");
        verticesEsperado.add("D");
        
        for(TVertice v : bea){
            vertices.add(v.getEtiqueta());
        }
        
        assertEquals(verticesEsperado, vertices);
        
    }
    
    @Test
    public void TestPrim(){
        System.out.println("TestPrim");
        TGrafoNoDirigido gndPrim = gnd.Prim();
        
        LinkedList<Comparable> vertices = new LinkedList<>();
        LinkedList<Comparable> verticesEsperado = new LinkedList<>();
        verticesEsperado.add("A");
        verticesEsperado.add("B");
        verticesEsperado.add("C");
        verticesEsperado.add("D");
        
        
        for(TVertice v : gndPrim.getVertices().values()){
            vertices.add(v.getEtiqueta());
        }
        
        assertEquals(verticesEsperado, vertices);
        assertEquals((Double)80.0, gndPrim.getCostoPrim());
       
        
        
    }
    
    @Test
    public void TestPuntosArticulacion(){
        System.out.println("Test Puntos de Articulación");
        LinkedList<TVertice> pa = gnd.puntosArticulacion();
        TVertice v1 = new TVertice("C");
        assertEquals(1, pa.size());
        assertEquals("C", pa.getFirst().getEtiqueta());
        
    }
    
    @Test
    public void TestTieneCiclo(){
        System.out.println("Test tiene ciclo");
        assertTrue(gd.tieneCiclo());
    }
    
    @Test
    public void TestTieneCicloConOrigen(){
        System.out.println("Test tiene ciclo pasando origen");
        assertTrue(gd.tieneCiclo("A"));
        assertTrue(gd.tieneCiclo("B"));
        assertTrue(gd.tieneCiclo("C"));
        assertFalse(gd.tieneCiclo("D"));
        assertFalse(gd.tieneCiclo("E"));

    }
    
    
    
    
}