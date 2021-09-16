/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Territorio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Rojas
 */
public class FondoPanel extends JPanel{
    
    private Image imagen;
    private ArrayList<Territorio> j1;
    private ArrayList<Territorio> j2;
    
    public FondoPanel(){
        this.setLayout(null);
        this.setSize(1280,720);
        this.setVisible(true);
    }
    
    @Override   
    public void paintComponent(Graphics g){     
        
        //Colorea todos territorios (puntos) que contenga la lista de territorios del jugador 1 (Usuario)
        for(int i=0; i<j1.size();i++)
        {
            //Se setea el color correspondiente al jugador 1 (azul) obteniendo los atributos de la clase
            g.setColor(new Color(j1.get(i).getX(),j1.get(i).getY(),j1.get(i).getZ()));
            //Se pinta el punto en las coordenadas correspondientes obteniendo los atributos de la clase
            g.fillOval(j1.get(i).getCoordenadax(), j1.get(i).getCoordenaday(), 25, 25);
            //Se setea el color a negro para representar los soldados dentro de los territorios (dentro de los puntos pintados)
            g.setColor(Color.black);
            //Se pinta el numero de soldados que tenga el territorio
            g.drawString(""+j1.get(i).getNumerodesoldados(), j1.get(i).getCoordenadax()+6, j1.get(i).getCoordenaday()+14);
            //Se setea el color a rojo para representar el indice del territorio
            g.setColor(Color.RED);
            //Negriña
            g.setFont(new java.awt.Font("Maiandra GD", 1, 11));
            //Se pinta el indice del territorio 
            g.drawString(""+j1.get(i).getId(), j1.get(i).getCoordenadax()-5, j1.get(i).getCoordenaday()-2);
        }
        
        //Colorea todos territorios (puntos) que contenga la lista de territorios del jugador 2 (jugador maquina)
        for(int i=0; i<j2.size();i++)
        {
            g.setColor(new Color(j2.get(i).getX(),j2.get(i).getY(),j2.get(i).getZ()));
            g.fillOval(j2.get(i).getCoordenadax(), j2.get(i).getCoordenaday(), 25, 25);
            g.setColor(Color.black);
            g.drawString(""+j2.get(i).getNumerodesoldados(), j2.get(i).getCoordenadax()+6, j2.get(i).getCoordenaday()+14);
            g.setColor(Color.RED);
            g.setFont(new java.awt.Font("Maiandra GD", 1, 11));
            g.drawString(""+j2.get(i).getId(), j2.get(i).getCoordenadax()-5, j2.get(i).getCoordenaday()-2);
        }       
    } 
    
    @Override
    public void paint (Graphics g){
          g.clearRect(0, 0, 1280, 720);
          imagen = new ImageIcon(getClass().getResource("/imagenes/mapa.png")).getImage();
          g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this );
          super.paint(g);
    }

    public ArrayList<Territorio> getJ1() {
        return j1;
    }

    public void setJ1(ArrayList<Territorio> j1) {
        this.j1 = j1;
    }

    public ArrayList<Territorio> getJ2() {
        return j2;
    }

    public void setJ2(ArrayList<Territorio> j2) {
        this.j2 = j2;
    }

}
