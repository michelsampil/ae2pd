/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3PD.TA6;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bphoa_000
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    String texto = "en este texto se duchan todos y si no se duchan duchan";
    TArbolSufijos trie = new TArbolSufijos(texto);

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testPalabraDuchan() {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("contar palabras duchan");
        int expResult = 3;
        int result = trie.predecir("duchan").size();
        assertEquals(expResult, result);
        
    }
}
