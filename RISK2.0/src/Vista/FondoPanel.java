/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Rojas
 */
public class FondoPanel extends JPanel{
    
    private Image imagen;
    
    @Override   
    public void paintComponent(Graphics g){     
           
          g.setColor(Color.red);
          g.fillOval(250, 120, 15, 15);
          g.fillOval(250, 210, 15, 15);
          g.fillOval(210, 280, 15, 15);
          g.fillOval(290, 460, 15, 15);
          g.fillOval(350, 400, 15, 15);
          g.fillOval(320, 336, 15, 15);
          g.fillOval(460, 60, 15, 15);
          g.fillOval(545, 110, 15, 15);
          g.fillOval(515, 170, 15, 15);
          g.fillOval(635, 110, 15, 15);
          g.fillOval(625, 215, 15, 15);
          g.fillOval(910, 125, 15, 15);
          g.fillOval(920, 235, 15, 15);
          g.fillOval(910, 335, 15, 15); 
          g.fillOval(780, 305, 15, 15);
          g.fillOval(620, 365, 15, 15);
          g.fillOval(720, 455, 15, 15);
          g.fillOval(675, 545, 15, 15);
          g.fillOval(1015, 425, 15, 15);
          g.fillOval(1145, 420, 15, 15);
          g.fillOval(1060, 540, 15, 15);
          g.fillOval(1165, 530, 15, 15);
    } 
    
    @Override
    public void paint (Graphics g){
        
          imagen = new ImageIcon(getClass().getResource("/imagenes/mapa.png")).getImage();
          g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this );
  
          super.paint(g);
    }
    
}
