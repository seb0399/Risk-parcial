/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class jugador {
    
    private int x,y,z;
    private ArrayList<Territorio> nodos = new ArrayList<Territorio>();


    public ArrayList<Territorio> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Territorio> nodos) {
        this.nodos = nodos;
    }
   
    public void añadir(Territorio a){
        nodos.add(a);
    }
}
