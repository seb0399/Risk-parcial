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
    
    //Color del jugador
    private int x,y,z;
    //Lista de territorios que posee el jugador
    private ArrayList<Territorio> nodos = new ArrayList<Territorio>();

    public jugador(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public ArrayList<Territorio> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Territorio> nodos) {
        this.nodos = nodos;
    }

    /*El metodo recibe el indice de la lista de territorios que sera seteado*/
    public void color(int i){
        this.nodos.get(i).setX(this.x);
        this.nodos.get(i).setY(this.y);
        this.nodos.get(i).setZ(this.z);
    }
    
    public void añadirterritorio(Territorio t){
        nodos.add(t);
    }
    
    public void remover(Territorio t){
        nodos.remove(t);
    }
    
}
