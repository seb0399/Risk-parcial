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

/**
 *
 * @author Carlos Rojas
 */
public class Controlador implements ActionListener{
    
    private Modelo modelo ;
    private Ventana vista;

    public Controlador (Modelo modelo, Ventana vista) {
        this.modelo = modelo;
        this.vista= vista;
        this.vista.setController(this);
        
        this.vista.btn2.setEnabled(false);
        this.vista.btn3.setEnabled(false);
        this.vista.btn4.setEnabled(false);
        
        modelo.creargrafo();
        modelo.refuerzos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(vista.btn1))
        {
            modelo.planificar(Integer.parseInt(vista.label2.getText()), Integer.parseInt(vista.txt1.getText()), Integer.parseInt(vista.txt2.getText()));
        }
    }
}
