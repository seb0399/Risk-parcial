/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Nodo {
    private String info;
    private boolean visita=false;
    ArrayList<Nodo> vecinos =  new ArrayList<Nodo>();
    ArrayList<Integer> distancia = new ArrayList<Integer>();
    ArrayList<Punto> c = new ArrayList<Punto>();
    Punto S;
//    public Nodo(String info){
//        info=info;
//    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isVisita() {
        return visita;
    }

    public void setVisita(boolean visita) {
        this.visita = visita;
    }

    public ArrayList<Nodo> getVecinos() {
        return vecinos;
    }

    public void setVecinos(ArrayList<Nodo> vecinos) {
        this.vecinos = vecinos;
    }

    public ArrayList<Integer> getDistancia() {
        return distancia;
    }

    public void setDistancia(ArrayList<Integer> distancia) {
        this.distancia = distancia;
    }

    public ArrayList<Punto> getC() {
        return c;
    }

    public void setC(ArrayList<Punto> c) {
        this.c = c;
    }

    public Punto getS() {
        return S;
    }

    public void setS(Punto S) {
        this.S = S;
    }


    
    public void crearcoordenada(){
        S = new Punto( 250, 120);
        c.add(S);
        S = new Punto( 250, 210);
        c.add(S);
         S = new Punto( 290, 460);
        c.add(S);
         S = new Punto( 350, 400);
        c.add(S);
         S = new Punto( 320, 336);
        c.add(S);
         S = new Punto( 460, 60);
        c.add(S);
         S = new Punto( 545, 110);
        c.add(S);
         S = new Punto( 515, 170);
        c.add(S);
         S = new Punto( 476, 186);
        c.add(S);
         S = new Punto( 635, 110);
        c.add(S);
         S = new Punto( 625, 215);
        c.add(S);
         S = new Punto( 910, 125);
        c.add(S);
         S = new Punto( 920, 235);
        c.add(S);
         S = new Punto( 910, 335);
        c.add(S);
         S = new Punto( 780, 305);
        c.add(S);
         S = new Punto( 620, 365);
        c.add(S);
         S = new Punto( 720, 455);
        c.add(S);
         S = new Punto( 675, 545);
        c.add(S);
         S = new Punto( 965, 445);
        c.add(S);
         S = new Punto( 1015, 425);
        c.add(S);
         S = new Punto( 1045, 445);
        c.add(S); 
        S = new Punto( 1010, 480);
        c.add(S);
         S = new Punto( 1060, 540);
        c.add(S);
         S = new Punto( 1165, 530);
        c.add(S);
         S = new Punto( 1145, 425);
        c.add(S);
        c.forEach(System.out::println);
        
    }
    public void agregarvecino(Nodo nodito, int dis){
        vecinos.add(nodito);
        distancia.add(dis);
        nodito.vecinos.add(this);
        nodito.distancia.add(dis);
       
    }
    
    public String mostrarnoditos(){
        this.visita=true;
        String s="";
        for(int i=0; i<vecinos.size();i++)
        {
            s+="Desde "+info+" hasta "+vecinos.get(i).info+"";
            if(!vecinos.get(i).visita){
                s+=vecinos.get(i).mostrarnoditos();
             }
        }
        return s;
    }
}
     
    
    

