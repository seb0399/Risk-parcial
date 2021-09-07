/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk2.pkg0;
import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Ventana;

/**
 *
 * @author Carlos Rojas
 */
public class RISK20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ventana v = new Ventana();
        
        Modelo m = new Modelo(v);
        
        Controlador c = new Controlador(m,v);
        
    }
    
}
