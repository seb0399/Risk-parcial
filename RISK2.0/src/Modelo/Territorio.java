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
public class Territorio {
    
    private int id;
    private int coordenadax, coordenaday;
    private int x,y,z;
    private int numerodesoldados;
    private boolean visita=false;
    ArrayList<Territorio> vecinos =  new ArrayList<Territorio>();

    public Territorio(int id, int numerodesoldados) {
        this.id = id;
        this.numerodesoldados = numerodesoldados;
    }
    
    public void coordenadas(int coordenadax, int coordenaday){
        this.coordenadax = coordenadax;
        this.coordenaday = coordenaday;
    }

    public int getCoordenadax() {
        return coordenadax;
    }

    public int getCoordenaday() {
        return coordenaday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumerodesoldados() {
        return numerodesoldados;
    }

    public void setNumerodesoldados(int numerodesoldados) {
        this.numerodesoldados = numerodesoldados;
    }

    public boolean isVisita() {
        return visita;
    }

    public void setVisita(boolean visita) {
        this.visita = visita;
    }

    public ArrayList<Territorio> getVecinos() {
        return vecinos;
    }

    public void setVecinos(ArrayList<Territorio> vecinos) {
        this.vecinos = vecinos;
    }


    public void agregarvecino(Territorio nodito){
        vecinos.add(nodito);
        nodito.vecinos.add(this);
    }    
    
}
