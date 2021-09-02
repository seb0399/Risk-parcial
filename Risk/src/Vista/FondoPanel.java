/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Nodo;
import Modelo.Operaciones;
import Modelo.Punto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class FondoPanel extends JPanel {
    private Image imagen;
    private int x = 225,y = 360;
    private Nodo n = new Nodo();
     ArrayList<Punto> c = new ArrayList<Punto>();
    
     
     public void paintComponent(Graphics g){     
       // g.clearRect(0,0,800, 800);
         g.setColor(Color.RED);
        
        for(int i=0; i<c.size()-1;i++)
        {
            int aleatorio= (int)(Math.random()*(2-1)+1);
            if(aleatorio==1)
            {
                g.setColor(Color.blue);
                g.fillOval(c.get(i).getX(),c.get(i).getY(), 15,15);
            }
            if(aleatorio==2)
            {
                g.setColor(Color.yellow);
                g.fillOval(c.get(i).getX(),c.get(i).getY(), 15,15);
            }
        }
        repaint();
//         g.fillOval(250, 120, 15, 15);
//          g.fillOval(250, 210, 15, 15);
//          g.fillOval(210, 280, 15, 15);
//          g.fillOval(290, 460, 15, 15);
//          g.fillOval(350, 400, 15, 15);
//          g.fillOval(320, 336, 15, 15);
//          g.fillOval(460, 60, 15, 15);
//          g.fillOval(545, 110, 15, 15);
//          g.fillOval(515, 170, 15, 15);
//          g.fillOval(476, 186, 15, 15);
//          g.fillOval(635, 110, 15, 15);
//          g.fillOval(625, 215, 15, 15);
//          g.fillOval(910, 125, 15, 15);
//          g.fillOval(920, 235, 15, 15);
//          g.fillOval(910, 335, 15, 15); 
//          g.fillOval(780, 305, 15, 15);
//          g.fillOval(620, 365, 15, 15);
//          g.fillOval(720, 455, 15, 15);
//          g.fillOval(675, 545, 15, 15);
//          g.fillOval(965, 445, 15, 15);
//          g.fillOval(1015, 425, 15, 15);
//          g.fillOval(1045, 445, 15, 15);
//          g.fillOval(1010, 480, 15, 15);
//          g.fillOval(1060, 540, 15, 15);
//          g.fillOval(1165, 530, 15, 15);
//          g.fillOval(1145, 425, 15, 15);
//         
         
          

    } 
    
 
    public void paint (Graphics g){
        
          imagen = new ImageIcon(getClass().getResource("/imagen/mapa.png")).getImage();
          g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this );
          
          super.paint(g);
    }
}
