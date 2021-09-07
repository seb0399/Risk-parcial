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
   jugador j1= new jugador();
   jugador j2= new jugador();
    
    public Modelo(Ventana v){
        this.ventana = v;
        this.territorio = new ArrayList<>();
    }
        
    
    
    public void creargrafo(){
        
        
           int soldados = (int) (Math.random()*(4-1)+1);
           Territorio t0= new Territorio(soldados,250, 120);
           territorio.add(t0);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t1= new Territorio(soldados,250, 210);
           territorio.add(t1);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t2= new Territorio(soldados,210, 280);
           territorio.add(t2);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t3= new Territorio(soldados,290, 460);
           territorio.add(t3);
          
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t4= new Territorio(soldados,320, 336);
           territorio.add(t4);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t5= new Territorio(soldados,350, 400);
           territorio.add(t5);
           
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t6= new Territorio(soldados,460, 60);
           territorio.add(t6);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t7= new Territorio(soldados,545, 110);
           territorio.add(t7);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t8= new Territorio(soldados,515, 170);
           territorio.add(t8);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t9= new Territorio(soldados,635, 110);
           territorio.add(t9);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t10= new Territorio(soldados,625, 215);
           territorio.add(t10);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t11= new Territorio(soldados,620, 365);
           territorio.add(t11);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t12= new Territorio(soldados,720, 455);
           territorio.add(t12);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t13= new Territorio(soldados,675, 545);
           territorio.add(t13);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t14= new Territorio(soldados,780, 305);
           territorio.add(t14);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t15= new Territorio(soldados,910, 125);
           territorio.add(t15);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t16= new Territorio(soldados,920, 235);
           territorio.add(t16);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t17= new Territorio(soldados,910, 335);
           territorio.add(t17);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t18= new Territorio(soldados,1015, 425);
           territorio.add(t18);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t19= new Territorio(soldados,1060, 540);
           territorio.add(t19);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t20= new Territorio(soldados,1145, 420);
           territorio.add(t20);
           
           soldados = (int) (Math.random()*(4-1)+1);
           Territorio t21= new Territorio(soldados,1165, 530);
           territorio.add(t21);
           
        
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
    
    public void crearyrepartir(){
        ArrayList<Territorio>ls = new ArrayList<>();
        ls.addAll(territorio);
        ArrayList<Territorio>rescate = new ArrayList<>();
        
        
        
        for(int i=0; i<11;i++)
        {
            int a= (int) (Math.random()*(ls.size()-1)+1);
            j1.añadir(ls.get(a));
            ls.remove(a);
            
        }
        System.out.println(ls.size());
        
        for(int j=0; j<ls.size();j++)
        {
            j2.añadir(ls.get(j));
            
            
        }System.out.println(ls.size());
        
        
        j1.getNodos().forEach(System.out::println);
        System.out.println("");
        j2.getNodos().forEach(System.out::println);
        ventana.getPanel().setJ1(j1.getNodos());
        ventana.getPanel().setJ2(j2.getNodos());
        ventana.getPanel().repaint();
        
       
    }
    
}
