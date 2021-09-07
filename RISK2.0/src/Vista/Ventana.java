/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import javax.swing.JFrame;

/**
 *
 * @author Carlos Rojas
 */
public class Ventana extends JFrame{
    
    private FondoPanel fondo = new FondoPanel();

   
    private Controlador c;
    
    public Ventana(){
       // this.setContentPane(fondo);
        this.setSize(1360,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Risk2.0");
        this.setVisible(true);
        this.initComponents();
       
    }
    
    public void initComponents(){
        this.fondo.setBounds(0, 0, 1280, 720);
        this.setVisible(true);
        this.add(fondo);
     
        
    }
     public void JPanel(){
        
    }
   
   
   
    public void setController(Controlador cont){
        this.c = cont;
   
    
    }
    
   public FondoPanel getPanel(){
       return this.fondo;
   }
    
    
    
}
 