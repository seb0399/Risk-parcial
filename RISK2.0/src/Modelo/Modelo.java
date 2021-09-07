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
   private ArrayList<Territorio> territorio;
   jugador j1 = new jugador(105,205,255);
   jugador j2 = new jugador(252, 255, 51);
    
    public Modelo(Ventana v){
        this.ventana = v;    
        this.territorio = new ArrayList<>();
    }  
    
    public void crearjugador(){
        
        ArrayList<Territorio> copia = territorio;
        
        

        for(int i=0; i<11;i++)
        {
            int indice = (int) (Math.random()*(copia.size()-1)+1);
            j1.añadirterritorio(copia.get(indice));
            j1.color(i);
            copia.remove(indice);
        }
        
        for(int i=0; i<copia.size();i++)
        {
            j2.añadirterritorio(copia.get(i));
            j2.color(i);
        }

        
        ventana.getPanel().setJ1(j1.getNodos());
        ventana.getPanel().setJ2(j2.getNodos());
        ventana.getPanel().repaint();    
    }
    
    public void creargrafo(){
        
        for(int i=0; i<22; i++ )
        {
            int soldados = (int) (Math.random()*(4-1)+1);
            Territorio t = new Territorio(i,soldados);
            territorio.add(t);
        }
        
        territorio.get(0).agregarvecino(territorio.get(1));
        territorio.get(0).agregarvecino(territorio.get(6));
        territorio.get(0).agregarvecino(territorio.get(15));
        territorio.get(0).coordenadas(250, 120);
        
        territorio.get(1).agregarvecino(territorio.get(2));
        territorio.get(1).coordenadas(250, 210);
        
        territorio.get(2).agregarvecino(territorio.get(3));
        territorio.get(2).coordenadas(210, 280);
        
        territorio.get(3).agregarvecino(territorio.get(4));
        territorio.get(3).agregarvecino(territorio.get(5));
        territorio.get(3).agregarvecino(territorio.get(21));
        territorio.get(3).coordenadas(290, 460);
        
        territorio.get(4).agregarvecino(territorio.get(5));
        territorio.get(4).coordenadas(320, 330);
          
        territorio.get(5).agregarvecino(territorio.get(11));
        territorio.get(5).coordenadas(350, 400);
        
        territorio.get(6).agregarvecino(territorio.get(7));
        territorio.get(6).coordenadas(460, 60);
        
        territorio.get(7).agregarvecino(territorio.get(8));
        territorio.get(7).agregarvecino(territorio.get(9));
        territorio.get(7).coordenadas(545, 110);
        
        territorio.get(8).agregarvecino(territorio.get(9));
        territorio.get(8).agregarvecino(territorio.get(10));
        territorio.get(8).coordenadas(515, 170);
        
        territorio.get(9).agregarvecino(territorio.get(10));
        territorio.get(9).agregarvecino(territorio.get(15));
        territorio.get(9).coordenadas(635, 110);
          
        territorio.get(10).agregarvecino(territorio.get(11));
        territorio.get(10).agregarvecino(territorio.get(14));
        territorio.get(10).agregarvecino(territorio.get(15));
        territorio.get(10).coordenadas(625, 215);
        
        territorio.get(11).agregarvecino(territorio.get(12));
        territorio.get(11).agregarvecino(territorio.get(14));
        territorio.get(11).coordenadas(620, 365);
          
        territorio.get(12).agregarvecino(territorio.get(13));
        territorio.get(12).agregarvecino(territorio.get(14));
        territorio.get(12).coordenadas(720, 455);
        
        territorio.get(13).agregarvecino(territorio.get(19));
        territorio.get(13).coordenadas(675, 545);
          
        territorio.get(14).agregarvecino(territorio.get(15));
        territorio.get(14).agregarvecino(territorio.get(16));
        territorio.get(14).agregarvecino(territorio.get(17));
        territorio.get(14).coordenadas(780, 305);
        
        territorio.get(15).agregarvecino(territorio.get(16));
        territorio.get(15).coordenadas(910, 125);
        
        territorio.get(16).agregarvecino(territorio.get(17));
        territorio.get(16).coordenadas(920, 235);
          
        territorio.get(17).agregarvecino(territorio.get(18));
        territorio.get(17).coordenadas(910, 335);
        
        territorio.get(18).agregarvecino(territorio.get(19));
        territorio.get(18).agregarvecino(territorio.get(20));
        territorio.get(18).coordenadas(1015, 425);
        
        territorio.get(19).agregarvecino(territorio.get(21));
        territorio.get(19).coordenadas(1060, 540);
          
        territorio.get(20).agregarvecino(territorio.get(21));
        territorio.get(20).coordenadas(1145, 420);
        
        territorio.get(21).coordenadas(1165, 530);
        
        crearjugador();
    }
    
    
}
