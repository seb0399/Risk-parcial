/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ventana;
import java.util.ArrayList;

/**
 *
 * @author Carlos Rojas
 */
public class Modelo {
    
   private Ventana ventana;
   private ArrayList<jugador> listajugadores;
   private ArrayList<Territorio> territorio;
    
    public Modelo(Ventana v){
        this.ventana = v;
        this.listajugadores = new ArrayList<>();    
        this.territorio = new ArrayList<>();
    }
    
     //g.setColor(new Color(255,30,5));
    //g.setColor(new Color(137,53,255));
    
    public void crearjugador(){
        
        
    }
    
    public void creargrafo(){
        
        for(int i=0; i<22; i++ )
        {
            int soldados = (int) (Math.random()*(4-1)+1);
            Territorio t = new Territorio(soldados);
            territorio.add(t);
        }
        
        territorio.get(0).agregarvecino(territorio.get(1));
        territorio.get(0).agregarvecino(territorio.get(6));
        territorio.get(0).agregarvecino(territorio.get(15));
        
        territorio.get(1).agregarvecino(territorio.get(2));
        
        territorio.get(2).agregarvecino(territorio.get(3));
        
        territorio.get(3).agregarvecino(territorio.get(4));
        territorio.get(3).agregarvecino(territorio.get(5));
        territorio.get(3).agregarvecino(territorio.get(21));
        
        territorio.get(4).agregarvecino(territorio.get(5));
        
        territorio.get(5).agregarvecino(territorio.get(11));
        
        territorio.get(6).agregarvecino(territorio.get(7));
        
        territorio.get(7).agregarvecino(territorio.get(8));
        territorio.get(7).agregarvecino(territorio.get(9));
        
        territorio.get(8).agregarvecino(territorio.get(9));
        territorio.get(8).agregarvecino(territorio.get(10));
        
        territorio.get(9).agregarvecino(territorio.get(10));
        territorio.get(9).agregarvecino(territorio.get(15));
        
        territorio.get(10).agregarvecino(territorio.get(11));
        territorio.get(10).agregarvecino(territorio.get(14));
        territorio.get(10).agregarvecino(territorio.get(15));
        
        territorio.get(11).agregarvecino(territorio.get(12));
        territorio.get(11).agregarvecino(territorio.get(14));
        
        territorio.get(12).agregarvecino(territorio.get(13));
        territorio.get(12).agregarvecino(territorio.get(14));
        
        territorio.get(13).agregarvecino(territorio.get(19));
        
        territorio.get(14).agregarvecino(territorio.get(15));
        territorio.get(14).agregarvecino(territorio.get(16));
        territorio.get(14).agregarvecino(territorio.get(17));
        
        territorio.get(15).agregarvecino(territorio.get(16));
        
        territorio.get(16).agregarvecino(territorio.get(17));
        
        territorio.get(17).agregarvecino(territorio.get(18));
        
        territorio.get(18).agregarvecino(territorio.get(19));
        territorio.get(18).agregarvecino(territorio.get(20));
        
        territorio.get(19).agregarvecino(territorio.get(21));
        
        territorio.get(20).agregarvecino(territorio.get(21));
    }
    
    
}
