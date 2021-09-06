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
    
    @Override   
    public void paintComponent(Graphics g){     

        for(int i=0; i<j1.size();i++)
        {
            g.setColor(new Color(j1.get(i).getX(),j1.get(i).getY(),j1.get(i).getZ()));
            g.fillOval(j1.get(i).getCoordenadax(), j1.get(i).getCoordenaday(), 15, 15);
        }
        
        for(int i=0; i<j2.size();i++)
        {
            g.setColor(new Color(j2.get(i).getX(),j2.get(i).getY(),j2.get(i).getZ()));
            g.fillOval(j2.get(i).getCoordenadax(), j2.get(i).getCoordenaday(), 15, 15);
        }
         
          
    } 
    
    @Override
    public void paint (Graphics g){
        
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
