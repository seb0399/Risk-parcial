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
    
    public boolean vecinoenemigo(){
        boolean vecinoazul=false;
        
        for (int i = 0; i < vecinos.size(); i++) {
            if(vecinos.get(i).getX() !=this.getX() && vecinos.get(i).getY() !=this.getY() && vecinos.get(i).getZ() !=this.getZ())
            {
                vecinoazul=true;
                i=vecinos.size();
            }
        }
        return vecinoazul;
    }
    
 public int enemigodebil(){

        int debil = vecinos.get(0).getNumerodesoldados();
        int atacar = vecinos.get(0).getId();
        int contador=0;

        for(int i=0;i<vecinos.size();i++)
        {
            if(vecinos.get(i).getX()!=this.getX() && vecinos.get(i).getY()!=this.getY() && vecinos.get(i).getZ()!=this.getZ())
            {

                if(contador==0)
                {
                    debil = vecinos.get(i).getNumerodesoldados();
                    atacar = vecinos.get(i).getId();
                }
                else 
                {
                    if(vecinos.get(i).getNumerodesoldados()<debil)
                    {
                        debil = vecinos.get(i).getNumerodesoldados();
                        atacar = vecinos.get(i).getId();
                    }
                }

                contador++;

            }
        }

        return atacar;
    }
    
    public boolean buscar(int llegada)
    {
        this.visita=true;
        boolean encontrado=false;
        
        for(int i=0; i<vecinos.size();i++)
        {
            if(vecinos.get(i).getId()==llegada && this.getX()==vecinos.get(i).getX() && this.getY()==vecinos.get(i).getY() && this.getZ()==vecinos.get(i).getZ())
            {
                encontrado=true;    
            }
            
        }
        if(encontrado==false)
        {
             for(int i=0; i<vecinos.size();i++)
            {
                if(this.getX()==vecinos.get(i).getX() && this.getY()==vecinos.get(i).getY() && this.getZ()==vecinos.get(i).getZ() && !vecinos.get(i).isVisita())
                {
                    encontrado=vecinos.get(i).buscar(llegada);
                    
                    if(encontrado==true)
                    {
                        i=vecinos.size();
                    }
                    
                }
            
            }
        }
        
        return encontrado;   
    }
    
}
