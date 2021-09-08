/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Rojas
 */
public class Controlador implements ActionListener{
    
    private Modelo modelo ;
    private Ventana vista;
    
    //variable que nos indica en que fase del juego estamos (Planificacion, Ataque, Fortalecer)
    private int fase;

    public Controlador (Modelo modelo, Ventana vista) {
        this.modelo = modelo;
        this.vista= vista;
        this.vista.setController(this);
        
        this.vista.btn2.setEnabled(false);
        this.vista.btn3.setEnabled(false);
        this.vista.btn4.setEnabled(false);
        this.fase=1;
        modelo.creargrafo();
        modelo.refuerzos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(vista.btn1))
        {
            //condicion que verifica si los soldados ingresados son mayores a 0
            if(Integer.parseInt(vista.txt2.getText())>0)
            {
                //comprueba que la diferencia entre reservas y soldados ingeresados no sea negativa
                int reservas = Integer.parseInt(vista.label2.getText())-Integer.parseInt(vista.txt2.getText());
            
                if(reservas>=0)
                {
                    //llamado al metodo planificar de la clase modelo
                    modelo.planificar(Integer.parseInt(vista.label2.getText()), 
                            Integer.parseInt(vista.txt1.getText()), Integer.parseInt(vista.txt2.getText()));
                    
                    //si las reservas llegan a 0 se permite iniciar el siguiente paso
                    if(reservas==0)
                    {
                        fase=2;
                        JOptionPane.showMessageDialog(null, "Buen trabajo, pulsa el boton siguiente para iniciar tu ataque");
                        vista.txt1.setText("");
                        vista.txt2.setText("");
                        this.vista.btn1.setEnabled(false);
                        this.vista.btn4.setEnabled(true);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad de soldados que no superen los disponibles");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad de soldados superior a 0");
            }   
        }
        else if(e.getSource().equals(vista.btn2))
        {
            //condicion que verifica que los territorios ingresados esten dentro del rango 0-21
            if(Integer.parseInt(vista.txt2.getText())>=0 || Integer.parseInt(vista.txt2.getText())<=21 && 
                    Integer.parseInt(vista.txt2.getText())>=0 || Integer.parseInt(vista.txt2.getText())<=21)
            {
                modelo.atacar(Integer.parseInt(vista.txt1.getText()), Integer.parseInt(vista.txt2.getText()));
            }
            
        }
        else if(e.getSource().equals(vista.btn4))
        {
            this.vista.btn4.setEnabled(false);
            
            switch(fase)
            {
                //Planificacion
                case 1:
                
                break;
                
                //Ataque
                case 2:
                    this.vista.btn2.setEnabled(true);
                    vista.label1.setText("");
                    vista.label2.setText("");
                    vista.label3.setText("Territorio que ataca");
                    vista.label4.setText("Territorio que defiende");
                break;
                
                //Fortificacion
                case 3:
                
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Error no identificado");
                break;
            }
        }
    }
}
