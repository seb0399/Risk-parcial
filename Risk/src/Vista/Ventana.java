/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class Ventana extends JFrame{
    private Controlador c;
    private FondoPanel fondo = new FondoPanel();
    private JButton iniciar = new JButton("Iniciar"); 
    Font fuente = new Font("Goudy Old Style", 3, 15
    );
    
     public Ventana(){
        this.setContentPane(fondo);
//        this.setContentPane(mono);
        this.setSize(1280,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("RIsk");
        this.setVisible(true);
        this.initComponents();
       
    }
     
     public void initComponents(){
            this.iniciar.setBounds(1000, 500, 80, 40);
            this.iniciar.setFont(fuente);
            this.setVisible(true);
            this.add(iniciar);
     }
    
}
