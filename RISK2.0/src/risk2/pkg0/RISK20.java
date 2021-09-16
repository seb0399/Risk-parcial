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
        
        //Nuestro lema: culpable hasta que se demuestre lo contrairo
        //Se crea un objeto ventana
        Ventana v = new Ventana();
        
        //Se crea un objeto modelo y se le envia la ventana anterior
        Modelo m = new Modelo(v);
        
        //Se crea un objeto controlador y se le envia el modelo y la ventana anterior
        Controlador c = new Controlador(m,v);
       
    }
    
}
