/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Nodo;
import Vista.Ventana;

/**
 *
 * @author Lenovo
 */
public class Controlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        Ventana p = new Ventana();
        Nodo n = new Nodo();
        n.crearcoordenada();
//        Modelo m = new Modelo(p);
//        Controlador c = new Controlador(m,p);
        p.setVisible(true);
    }
        
}
