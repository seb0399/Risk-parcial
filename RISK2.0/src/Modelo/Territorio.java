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
    
    //Indice del territorio
    private int id;
    //Coordenadas del punto que representa el territorio en el mapa
    private int coordenadax, coordenaday;
    //Colores del jugador
    private int x,y,z;
    //Numero de soldados en el territorio
    private int numerodesoldados;
    //Variable que verifica si el territorio ha sido visitado
    private boolean visita=false;
    //Lista de vecinos del territorio
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
        
        boolean vecinoazul = false;
        
        for(int i=0;i<vecinos.size();i++)
        {
            if(vecinos.get(i).getX()!=this.getX() && vecinos.get(i).getY()!=this.getY() && vecinos.get(i).getZ()!=this.getZ())
            {
                vecinoazul = true;
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
    
    public boolean vecinoamigo(){
        
        int contarvecinosamigos = 0;
        boolean fortifica = false;
        
        for(int i=0;i<vecinos.size();i++)
        {
            if(vecinos.get(i).getX()==this.getX() && vecinos.get(i).getY()==this.getY() && vecinos.get(i).getZ()==this.getZ())
            {
                contarvecinosamigos++;
            }
        }
        
        if(contarvecinosamigos==vecinos.size() && this.getNumerodesoldados()>1)
        {
            fortifica = true;
        }
        
        return fortifica;
    }
    
    public boolean amigodebil(){
        
        boolean amarilloazul = false;
        
        for(int i=0; i<vecinos.size();i++)
        {
            if(this.getX()!=vecinos.get(i).getX() && this.getY()!=vecinos.get(i).getY() && this.getZ()!=vecinos.get(i).getZ())
            {
                amarilloazul = true;
            }
        }
        
        return amarilloazul;
    }
    
    /*El metodo recibe
                    
      Indice del territorio que recibe soldados*/
    
    public boolean buscar(int llegada)
    {
        //Variable local que establece que este territorio ha sido visitado en la busqueda
        this.visita=true;
        //Variable que indica si el trritorio a buscar fue encontrado
        boolean encontrado=false;
        
        //Se recorre la lista de vecinos del territorio indicado
        for(int i=0; i<vecinos.size();i++)
        {
            //Si en la lista se encuetra al territorio de llegada y comparten colores entra a la condicion
            if(vecinos.get(i).getId()==llegada && this.getX()==vecinos.get(i).getX() && this.getY()==vecinos.get(i).getY() && this.getZ()==vecinos.get(i).getZ())
            {
                //El territorio de llegada fue encontrado
                encontrado=true;    
            }
            
        }
        
        //Si el territorio no fue encontrado se realiza otro procedimiento
        if(encontrado==false)
        {
            //Nuevamente se recorre la lista de vecinos del territorio
            for(int i=0; i<vecinos.size();i++)
            {
                //Si el vecino comparte territorio entra al a condicion
                if(this.getX()==vecinos.get(i).getX() && this.getY()==vecinos.get(i).getY() && this.getZ()==vecinos.get(i).getZ() && !vecinos.get(i).isVisita())
                {
                    /*Se llama al metodo buscar del territorio vecino (recuerdece que el metodo
                    retorna un boolean que indica si el territorio de llegada fue encontrado*/
                    
                    encontrado=vecinos.get(i).buscar(llegada);
                    
                    //Si el territorio de llegada fue encnrado se entra a la condicion
                    if(encontrado==true)
                    {
                        //Se rompe el for para dejar de buscar
                        i=vecinos.size();
                    }
                    
                }
            
            }
        }
        
        //Se retorna la variable que indica si el territorio de llegada fue encontrado
        return encontrado;   
    }
    
}
