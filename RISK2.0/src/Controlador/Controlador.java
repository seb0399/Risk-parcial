/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.FondoPanel;
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
    private FondoPanel pantalla;

    public Controlador (Modelo modelo, Ventana vista) {
        this.modelo = modelo;
        this.vista= vista;
        this.vista.setController(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
