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
        this.vista.btn5.setEnabled(false);
        this.vista.txt3.setEnabled(false);
        this.fase=1;
        modelo.creargrafo();
        modelo.refuerzos();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Boton Planificar
        if(e.getSource().equals(vista.btn1))
        {
            //Try-Catch por si el usuario no ingresa valores numericos en las cajas de texto
            try{
                
                //Condicion que verifica si los soldados ingresados son mayores a 0
                if(Integer.parseInt(vista.txt2.getText())>0)
                {
                    //Comprueba que la diferencia entre reservas y soldados ingeresados no sea negativa
                    int reservas = Integer.parseInt(vista.label2.getText())-Integer.parseInt(vista.txt2.getText());
            
                    if(reservas>=0)
                    {
                        /*Llamado al metodo planificar de la clase modelo 
                    
                        EL metodo retorna un valor booleano para verificar si el territorio ingresado le pertenece o no.
                        
                        Si el territorio le pertenece realizara las acciones correspondientes en el metodo
                        Si el territorio no le pretenece se salta todas las acciones y retorna false 
                    
                        Al metodo se le envia:
                    
                        La nueva cantidad de soldados disponibles
                        El indice del territorio que desea fortalecer
                        La cantidad de soldados que desea ingresar en el territorio*/
                    
                        boolean continuar = modelo.planificar(Integer.parseInt(vista.label2.getText()), 
                            Integer.parseInt(vista.txt1.getText()), Integer.parseInt(vista.txt2.getText()));
                    
                    
                        if(continuar==false)
                        {
                            JOptionPane.showMessageDialog(null, "El territorio no le pertenece");
                        }
                    
                        //Si las reservas llegan a 0 se permite iniciar el siguiente paso
                        if(reservas==0 && continuar==true)
                        {
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
            
            }catch(Exception a){
                JOptionPane.showMessageDialog(null,"Ingrese valores numericos en las cajas de texto");
            }
        }
        //Boton Atacar
        else if(e.getSource().equals(vista.btn2))
        {
            //Try-Catch por si el usuario no ingresa valores numericos en las cajas de texto
            try{
                
                //Condicion que verifica que los territorios ingresados esten dentro del rango 0-21
                if(Integer.parseInt(vista.txt1.getText())>=0 && Integer.parseInt(vista.txt1.getText())<=21 && 
                    Integer.parseInt(vista.txt2.getText())>=0 && Integer.parseInt(vista.txt2.getText())<=21)
                {
                    //verifica que los territorios no sean iguales
                    if(Integer.parseInt(vista.txt1.getText())==Integer.parseInt(vista.txt2.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "El territorio que quiere atacar es el mismo que defiende");
                    }
                    else
                    {
                        /*Llamado al metodo atacar de la clase modelo 
                    
                        EL metodo retorna un valor booleano para verificar si el jugador gano la batalla.
                        
                        Si el jugador gano la batalla se bloquean todos los botones a excepcion del boton 
                        balancear, es decir, se obliga al jugador a balancear.
                        
                        Si el jugador perdio la batalla puede replantear su ataque, es decir, no se desbloquea el boton balancear y 
                        puede decidir si ataca otra vez o pasa a la siguiente etapa.
                    
                        Al metodo se le envia:
                    
                        Indice del territorio que ataca
                        Indice del territorio que defiende (territorio que va a ser atacado)*/
                        
                        boolean ganar = modelo.atacar(Integer.parseInt(vista.txt1.getText()), Integer.parseInt(vista.txt2.getText()));
                    
                        //Condicion que verifica si desbloquea o no el boton balancear
                        if(ganar==true)
                        {
                            this.vista.btn2.setEnabled(false);
                            this.vista.label3.setText("Soldados en el territorio atacante");
                            this.vista.label4.setText("Soldados en el territorio conquistado");
                            this.vista.txt1.setText("");
                            this.vista.txt2.setText("");
                            this.vista.btn4.setEnabled(false);
                            this.vista.btn5.setEnabled(true);
                        }
                    }
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Ingrese territorios que esten en el mapa");
                }
            }catch(Exception a){   
                JOptionPane.showMessageDialog(null,"Ingrese valores numericos en las cajas de texto");
            }
            
        }
        //Balancear
        else if(e.getSource().equals(vista.btn5))
        {
            //Try-Catch por si el usuario no ingresa valores numericos en las cajas de texto
            try
            {
                /*Llamado al metodo balancear de la clase modelo 
                    
                EL metodo retorna un valor booleano para verificar si el jugador balanceo de manera correcta.
                        
                Si el jugador balanceo de manera correcta regresa a la fase de atacar
                        
                Si el jugador balanceo de manera incorrecta se le pedira que realice nuevamente la accion.
                    
                Al metodo se le envia:
                    
                Numero de soldados que va a contener el territorio que ataco
                Numero de soldados que va a contener el territorio que conquisto*/
                
                boolean desbloquear = modelo.balancear(Integer.parseInt(vista.txt1.getText()), Integer.parseInt(vista.txt2.getText()));
            
                //Condicion que verifica que el jugador halla balanceado de la manera correcta
                if(desbloquear==true)
                {
                    this.vista.btn5.setEnabled(false);
                    this.vista.label3.setText("Indice Territorio que ataca");
                    this.vista.label4.setText("Indice Territorio que defiende");
                    this.vista.txt1.setText("");
                    this.vista.txt2.setText("");
                    this.vista.btn2.setEnabled(true);
                    this.vista.btn4.setEnabled(true);
                }
                
                /*Si la lista de territorios del jugador 1 (Usuario) es igual a 22 eso significa que el jugador gano el juego,
                por lo cual se bloquean todos los botones*/
                if(modelo.getJ1().getNodos().size()==22)
                {
                    JOptionPane.showMessageDialog(null, "Has Ganado :D"); 
                       
                    this.vista.btn1.setEnabled(false);
                    this.vista.btn2.setEnabled(false);
                    this.vista.btn3.setEnabled(false);
                    this.vista.btn4.setEnabled(false);
                    this.vista.btn5.setEnabled(false);
                    this.vista.txt1.setEnabled(false);
                    this.vista.txt2.setEnabled(false);
                    this.vista.txt3.setEnabled(false);
                    this.vista.label3.setText("Ganaste");
                    this.vista.label4.setText("Ganaste");
                    this.vista.label5.setText("Ganaste");
                }
                
            }catch(Exception a) {
                JOptionPane.showMessageDialog(null,"Ingrese valores numericos en las cajas de texto");
            }                 
        }
        //Fortalecer
        else if (e.getSource().equals(vista.btn3))
        {
            //Try-Catch por si el usuario no ingresa valores numericos en las cajas de texto
            try
            {
                //Condicion que verifica que el jugador no halla ingresado territorio que no esten en el mapa
                if(Integer.parseInt(vista.txt1.getText())>21 || Integer.parseInt(vista.txt1.getText())<0 || 
                    Integer.parseInt(vista.txt2.getText())>21 || Integer.parseInt(vista.txt2.getText())<0)
                {
                    JOptionPane.showMessageDialog(null, "Ingrese territorios que esten en el mapa");
                }
                else
                {
                    //Condicion que verifica que la cantidad de soldados a trasladar sea superior a 0
                    if(Integer.parseInt(vista.txt3.getText())<0)
                    {
                        JOptionPane.showMessageDialog(null, "Ingrese valores positivos");
                    }
                    else if(Integer.parseInt(vista.txt3.getText())==0)
                    {
                        JOptionPane.showMessageDialog(null, "¿Por que quisieras trasladar 0 soldados?");
                    }
                    else if(Integer.parseInt(vista.txt1.getText())==Integer.parseInt(vista.txt2.getText()))
                    {   
                        JOptionPane.showMessageDialog(null, "El territorio de llegada es igual al territorio de partida");
                    }
                    else
                    {
                        /*Llamado al metodo foritficar de la clase modelo 
                    
                        EL metodo retorna un valor booleano para verificar si el jugador traslado soldados de manera adecuada
                        
                        Si el jugador realizo la accion correctamente el juego lo obliga a pasar de etapa.
                        
                        Si el jugador no realizo la accion correctamente el juego permite que reingrese los datos o pase de etapa.
                    
                        Al metodo se le envia:
                    
                        Indice del territorio que envia soldados
                        Indice del territorio que recibe soldados
                        Cantidad de soldados a trasladar*/
                        
                        boolean siguienteetapa = modelo.fortificar(Integer.parseInt(vista.txt1.getText()),
                             Integer.parseInt(vista.txt2.getText()),Integer.parseInt(vista.txt3.getText()));
                        
                        //Condicion que verifica que el jugador halla realizado la accion correctamente
                        if(siguienteetapa==true)
                        {
                            JOptionPane.showMessageDialog(null, "Etapa de fortificacion terminada, pulse el boton siguiente para continuar");
                            this.vista.txt1.setText("");
                            this.vista.txt2.setText("");
                            this.vista.txt3.setText("");
                            this.vista.label5.setText("");
                            this.vista.btn3.setEnabled(false);
                        }
                    }
                }
            }catch(Exception a){
                JOptionPane.showMessageDialog(null,"Ingrese valores numericos en las cajas de texto");
            }
        }
        //Continuar
        else if(e.getSource().equals(vista.btn4))
        {
            //Indica que fase del juego continua cada vez que el jugador pulsa el boton continuar
            fase++;
            
            switch(fase)
            {
                //Planificacion
                case 1:
                this.vista.label1.setText("Soldados disponibles");
                this.vista.label3.setText("Indice del territorio a fortalecer: ");
                this.vista.label4.setText("Cantidad de soldados a ingresar: ");
                this.vista.txt1.setText("");
                this.vista.txt2.setText("");
                this.vista.btn1.setEnabled(true);
                this.vista.btn4.setEnabled(false);
                modelo.refuerzos();
                break;
                
                //Ataque
                case 2:
                    this.vista.btn2.setEnabled(true);
                    vista.label1.setText("");
                    vista.label2.setText("");
                    vista.label3.setText("Indice Territorio que ataca");
                    vista.label4.setText("Indice Territorio que defiende");
                break;
                
                //Fortificacion
                case 3:
                    JOptionPane.showMessageDialog(null, "Etapa de fortificacion");
                    this.vista.btn1.setEnabled(false);
                    this.vista.btn2.setEnabled(false);
                    this.vista.btn3.setEnabled(true);
                    this.vista.btn5.setEnabled(false);
                    vista.txt1.setText("");
                    vista.txt1.setText("");
                    vista.label3.setText("Mover de ");
                    vista.label4.setText("Mover hacia ");
                    vista.label5.setText("Cantidad de soldados a mover ");
                    this.vista.txt3.setEnabled(true);
                break;
                
                //La maquina juega
                case 4:
                    this.vista.txt3.setEnabled(false);
                    this.vista.btn3.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Turno del enemigo");
                    
                    /*Llamado al metodo maquina de la clase modelacion
                    
                    Retorna un valor booleano que indica si la maquina perdio o no*/
                    boolean perder = modelo.maquina();
                    
                    //Condicion que verifica si la maquina perdio o no
                    if(perder==true)
                    {
                        this.vista.btn1.setEnabled(false);
                        this.vista.btn2.setEnabled(false);
                        this.vista.btn3.setEnabled(false);
                        this.vista.btn4.setEnabled(false);
                        this.vista.btn5.setEnabled(false);
                        this.vista.txt1.setEnabled(false);
                        this.vista.txt2.setEnabled(false);
                        this.vista.txt3.setEnabled(false);
                        this.vista.label3.setText("Perdiste");
                        this.vista.label4.setText("Perdiste");
                        this.vista.label5.setText("Perdiste");
                        
                    }
                    else{
                        /*Si la maquina no perdio la variable se reinica para
                          reiniciar el proceso*/
                        fase=0;
                    }
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Error no identificado");
                break;
                
            }
            
        }
    }
}
