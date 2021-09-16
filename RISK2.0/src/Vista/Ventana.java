/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Rojas
 */
public class Ventana extends JFrame{
    
    public FondoPanel fondo = new FondoPanel();
    public JPanel panel = new JPanel();
    public JLabel label1 = new JLabel("Soldados disponibles"); 
    public JLabel label2 = new JLabel("");
    public JLabel label3 = new JLabel("Indice del territorio a fortalecer: ");
    public JLabel label4 = new JLabel("Cantidad de soldados a ingresar: ");
    public JLabel label5 = new JLabel("");
    public JButton btn1 = new JButton("Planificar");
    public JButton btn2 = new JButton("Atacar");
    public JButton btn3 = new JButton("Fortificar");
    public JButton btn4 = new JButton("Siguiente etapa");
    public JButton btn5 = new JButton("Balancear");
    public JTextField txt1 = new JTextField();
    public JTextField txt2 = new JTextField();
    public JTextField txt3 = new JTextField();
    private Controlador c;

    
    public Ventana(){
       // this.setContentPane(fondo);
        this.setSize(1300,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Risk2.0");
        this.setVisible(true);
        this.initComponents();
       
    }
    
    public void initComponents(){
        
        this.panel.setLayout(null);
        this.fondo.setBounds(0, 0, 1280, 720);
        this.setVisible(true);
        this.add(fondo);

        this.label1.setBounds(60,60,200,20);
        this.panel.add(label1);
        
        this.label2.setBounds(270,60,90,20);
        this.panel.add(label2);

        this.label3.setBounds(60,100,200,20);
        this.panel.add(label3);
        this.txt1.setBounds(270,100,90,20);
        this.panel.add(txt1);

        this.label4.setBounds(60,140,200,20);
        this.panel.add(label4);
        this.txt2.setBounds(270,140,90,20);
        this.panel.add(txt2);
        
        this.label5.setBounds(60,185,200,20);
        this.panel.add(label5);
        this.txt3.setBounds(270,185,90,20);
        this.panel.add(txt3);
        
        this.btn1.setBounds(900, 60, 90, 20);
        this.panel.add(btn1);

        this.btn2.setBounds(900, 100, 90, 20);
        this.panel.add(btn2);

        this.btn3.setBounds(1000, 60, 90, 20);
        this.panel.add(btn3);

        this.btn4.setBounds(1000, 100, 90, 20);
        this.panel.add(btn4);
        
        this.btn5.setBounds(1000, 140, 90, 20);
        this.panel.add(btn5);
        
        

        this.panel.setBounds(0, 720, 1280, 280);
        this.panel.setBackground(new Color(0,120,240));
        this.setVisible(true);
        this.add(panel);
    }
   
    public void setController(Controlador cont){
        this.c = cont;
        this.btn1.addActionListener((ActionListener) this.c);
        this.btn2.addActionListener((ActionListener) this.c);
        this.btn3.addActionListener((ActionListener) this.c);
        this.btn4.addActionListener((ActionListener) this.c);
        this.btn5.addActionListener((ActionListener) this.c);
    }
    
   public FondoPanel getPanel(){
       return this.fondo;
   }
}