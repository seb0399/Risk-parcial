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
     private ArrayList<Territorio> j1= new ArrayList();
     private ArrayList<Territorio> j2=new ArrayList();
  
    @Override   
    public void paintComponent(Graphics g){     
         g.setColor(new Color(255,30,5));
           for(int i = 0; i<j1.size();i++)
           {
               g.fillOval(j1.get(i).getX(),j1.get(i).getY(),15,15);
           }
           
            g.setColor(new Color(137,53,255));
           for(int j = 0; j<j2.size();j++)
           {
               g.fillOval(j2.get(j).getX(),j2.get(j).getY(),15,15);
           }
        
//          g.setColor(new Color(137,53,255));
//         // g.fillOval(250, 120, 15, 15);
//         // g.fillOval(250, 210, 15, 15);
//        //g.fillOval(210, 280, 15, 15);
//       // g.fillOval(290, 460, 15, 15);
//       // g.fillOval(350, 400, 15, 15);
//       //  g.fillOval(320, 336, 15, 15);
// ///     g.fillOval(460, 60, 15, 15);
//     ///7     g.fillOval(545, 110, 15, 15);
//    //    g.fillOval(515, 170, 15, 15);
//   ///      g.fillOval(635, 110, 15, 15);
//    ///    g.fillOval(625, 215, 15, 15);
//        //  g.fillOval(910, 125, 15, 15);//15
//         // g.fillOval(920, 235, 15, 15);//16
//      // g.fillOval(910, 335, 15, 15); //17
//      //   g.fillOval(780, 305, 15, 15);//14
//     //    g.fillOval(620, 365, 15, 15);//11
//      //   g.fillOval(720, 455, 15, 15);//12
//   //       g.fillOval(675, 545, 15, 15);//13
//        //  g.fillOval(1015, 425, 15, 15);//18
//     //    g.fillOval(1145, 420, 15, 15);//20
//         // g.fillOval(1060, 540, 15, 15);//19
//          g.fillOval(1165, 530, 15, 15);
          
          
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
