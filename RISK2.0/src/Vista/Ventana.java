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
    /**
     * se agregan botones, jlabel, caja de texto y paneles a la ventana
     */
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
       // tcaracteristicas de la ventana
        this.setSize(1300,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Risk2.0");
        this.setVisible(true);
        this.initComponents();
       
    }
    
    public void initComponents(){
        //Panel correspondiente al mapa de risk
        this.panel.setLayout(null);
        this.fondo.setBounds(0, 0, 1280, 720);
        this.setVisible(true);
        this.add(fondo);

        //label que imprime soldados disponibles
        this.label1.setBounds(60,60,200,20);
        this.panel.add(label1);
        
        //label que imprime el numero de soldados disponibles
        this.label2.setBounds(270,60,90,20);
        this.panel.add(label2);

        /*label que recibe indice del territorio a fortalecer, luego territorio
        luego indice del territorio que ataca*/
        this.label3.setBounds(60,100,200,20);
        this.panel.add(label3);
        /*
        caja de texto que da los datos del label anterior
        */
        this.txt1.setBounds(270,100,90,20);
        this.panel.add(txt1);

        /*label que recibe numero de soldados a ingresar, luego territorio
        luego indice de terriotrio que defiende*/
        this.label4.setBounds(60,140,200,20);
        this.panel.add(label4);
        /*
        caja de texto que da los datos del label anterior
        */
        this.txt2.setBounds(270,140,90,20);
        this.panel.add(txt2);
        
        /*
        recibe lo que se mando dl modelo, para cuando se oprime el boton de fotalecer
        osea, este se actualiza cuando se oprime el boton fortalecer
        
        */
        this.label5.setBounds(60,185,200,20);
        this.panel.add(label5);
        this.txt3.setBounds(270,185,90,20);
        this.panel.add(txt3);
        
        /*boton que sirve para activar el metodo de modelo que planifica la ubicacion de los 
        soldados nuevos ingresados en los indices*/
        this.btn1.setBounds(900, 60, 90, 20);
        this.panel.add(btn1);

        /*
        boton que se oprime y activa el metodo atacar de modelo
        */
        this.btn2.setBounds(900, 100, 90, 20);
        this.panel.add(btn2);
/*
        boton que se oprime y activa el metodo fortalecer de modelo
        */
        this.btn3.setBounds(1000, 60, 90, 20);
        this.panel.add(btn3);
/*
        boton que se oprime y da paso al turno de la maquina 
        */
        this.btn4.setBounds(1000, 100, 90, 20);
        this.panel.add(btn4);
        
        /*
        boton que se opimr luego de haber conquistado un territorio, sirve para balancear los soldados
        que se desee dejar en el nuevo territorio
        */
        this.btn5.setBounds(1000, 140, 90, 20);
        this.panel.add(btn5);
        
        /*
        panel que contiene los label, las caja de texto y los botones del programa
        */
        this.panel.setBounds(0, 720, 1280, 280);
        this.panel.setBackground(new Color(0,120,240));
        this.setVisible(true);
        this.add(panel);
    }
   
    public void setController(Controlador cont){
        /*
        permite que los botnoes realizen una funcion al oprimirlos
        */
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