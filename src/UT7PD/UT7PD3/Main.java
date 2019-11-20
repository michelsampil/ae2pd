/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT7PD.UT7PD3;

import java.util.PriorityQueue;

/**
 *
 * @author bphoa_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(10);
        q.offer(4);
        q.offer(2);
        q.offer(8);
        q.offer(6);

        while (!q.isEmpty()) {
            Integer i = q.poll();
            System.out.println(i);
        }
        */
        int[] datosParaClasificar = new int[11];
        datosParaClasificar[0]=29;
        datosParaClasificar[1]=2;
        datosParaClasificar[2]=3;
        datosParaClasificar[3]=1;
        datosParaClasificar[4]=5;
        datosParaClasificar[5]=6;
        datosParaClasificar[6]=73;
        datosParaClasificar[7]=66;
        datosParaClasificar[8]=8;
        datosParaClasificar[9]=3;
        datosParaClasificar[10]=17;

        
        
        int lenght = datosParaClasificar.length;
        int[] datosClasificados = new int[lenght];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(lenght);
        for (int i = 0; i < lenght; i++) {
            q.offer(datosParaClasificar[i]);
        }
        System.out.println(q.size());
        int position = 0;
        while (!q.isEmpty()) {
            
            int i = q.poll();
            datosClasificados[position] = i;
            System.out.println(datosClasificados[position]);
            position++;     
        }
        
        
    }
        
    }


