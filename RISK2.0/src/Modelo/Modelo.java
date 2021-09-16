/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ventana;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Rojas
 */
public class Modelo {
    
   private Ventana ventana;
   private ArrayList<Territorio> territorio;
   jugador j1 = new jugador(105,205,255);
   jugador j2 = new jugador(252, 255, 51);
   int indiceatar,indicedefender;
    
    public Modelo(Ventana v){
        this.ventana = v;    
        this.territorio = new ArrayList<>();
    }  
    
    public boolean maquina(){
        
        boolean perder = false;
        
        //Planificar
        int indice = (int) (Math.random()*(j2.getNodos().size()-1)+0);     
        j2.getNodos().get(indice).setNumerodesoldados(j2.getNodos().get(indice).getNumerodesoldados()+j2.getNodos().size());
        ventana.getPanel().setJ2(j2.getNodos());
        ventana.getPanel().repaint();
        
        JOptionPane.showMessageDialog(null, "El enemigo ha terminado de planificar");
        
        //Atacar
        int seguiratacando = (int)(Math.random()*(4-1+1)+1);
        
        while(seguiratacando>1)
        {        
            
            int max=0;
            int indiceamarillo=0;
        
            for(int i=0; i<j2.getNodos().size();i++)
            {
                if(j2.getNodos().get(i).vecinoenemigo()==true && j2.getNodos().get(i).getNumerodesoldados()>max)
                {
                    max=j2.getNodos().get(i).getNumerodesoldados();
                    indiceamarillo = i;
                }
            }
        
            int enemigo = j2.getNodos().get(indiceamarillo).enemigodebil();
        
            int indiceazul=0;
        
            for(int i=0; i<j1.getNodos().size();i++)
            {
                if(enemigo==j1.getNodos().get(i).getId())
                {
                    indiceazul = i;
                }
            }   
            
            if(j2.getNodos().get(indiceamarillo).getNumerodesoldados()>1)
            {
            
                JOptionPane.showMessageDialog(null, "El enemigo piensa atacar tu territorio "+j1.getNodos().get(indiceazul).getId()+" con el territorio "+j2.getNodos().get(indiceamarillo).getId());
        
                //pelea
            
                boolean salir = false;
        
                do
                {
                    int total = j2.getNodos().get(indiceamarillo).getNumerodesoldados()+j1.getNodos().get(indiceazul).getNumerodesoldados();
                    int dado = (int) (Math.random()*(total-1)+0);
            
                    if(dado<=j2.getNodos().get(indiceamarillo).getNumerodesoldados())
                    {
                        //ganan el que ataca
                        j1.getNodos().get(indiceazul).setNumerodesoldados(j1.getNodos().get(indiceazul).getNumerodesoldados()-1);
                    }
                    else
                    {
                        //gana el que defiende
                        j2.getNodos().get(indiceamarillo).setNumerodesoldados(j2.getNodos().get(indiceamarillo).getNumerodesoldados()-1);
                    }
        
                    if(j2.getNodos().get(indiceamarillo).getNumerodesoldados()==1)
                    {
                        salir = true;
                        JOptionPane.showMessageDialog(null, "Has ganado la batalla");
                    }
                    else if(j1.getNodos().get(indiceazul).getNumerodesoldados()==0)
                    {
                        salir = true;
                        JOptionPane.showMessageDialog(null, "Has perdido un territorio");
                        int maximo = j2.getNodos().get(indiceamarillo).getNumerodesoldados()-1;
                        int soldadost1 = (int) (Math.random()*((maximo-1)+1)+1);            
                        j2.getNodos().get(indiceamarillo).setNumerodesoldados(j2.getNodos().get(indiceamarillo).getNumerodesoldados()-soldadost1);
                        j1.getNodos().get(indiceazul).setNumerodesoldados(soldadost1);

                        j2.añadirterritorio(j1.getNodos().get(indiceazul));
                        j2.color(j2.getNodos().size()-1);        
                        j1.remover(j1.getNodos().get(indiceazul));
                    }
                    
                }while(salir==false);
        
                ventana.getPanel().setJ1(j1.getNodos());
                ventana.getPanel().setJ2(j2.getNodos());
                ventana.getPanel().repaint();
                
                seguiratacando = (int)(Math.random()*(2-1+1)+1);
            }
            else
            {
                seguiratacando = (int)(Math.random()*(2-1+1)+1);
            }
            
        }
        
        if(j2.getNodos().size()==22)
        {
            perder = true;
            JOptionPane.showMessageDialog(null, "Has perdido :c");
        }
        else
        {
            //Fortalecer
        
            int indicequefortifica = 0;
            boolean fortifica = false;
        
            for(int i=0;i<j2.getNodos().size();i++)
            {
                fortifica = j2.getNodos().get(i).vecinoamigo();
            
                if(fortifica==true)
                {
                    indicequefortifica=i;
                    i = j2.getNodos().size();
                } 
            }
        
            if(fortifica==true)
            {
                int contadoraux=0;
                int indiceafortificar=0;
                int menorsoldados = 0;
            
                for(int i=0; i<j2.getNodos().size();i++)
                {
                    boolean amarilloazul = j2.getNodos().get(i).amigodebil();
                
                    if(amarilloazul==true && contadoraux==0 && j2.getNodos().get(indicequefortifica).buscar(j2.getNodos().get(i).getId())==true)
                    {
                        indiceafortificar=i;
                        menorsoldados = j2.getNodos().get(i).getNumerodesoldados();
                        contadoraux++;
                    }
                
                    if(amarilloazul==true && j2.getNodos().get(i).getNumerodesoldados()<menorsoldados && j2.getNodos().get(indicequefortifica).buscar(j2.getNodos().get(i).getId())==true)
                    {
                        indiceafortificar=i;
                        menorsoldados = j2.getNodos().get(i).getNumerodesoldados();
                    }
                }
            
                JOptionPane.showMessageDialog(null, "El enemigo fortifica su territorio "+j2.getNodos().get(indiceafortificar).getId()+" con soldados del territorio "+j2.getNodos().get(indicequefortifica).getId());
                j2.getNodos().get(indiceafortificar).setNumerodesoldados(j2.getNodos().get(indiceafortificar).getNumerodesoldados()+(j2.getNodos().get(indicequefortifica).getNumerodesoldados()-1));
                j2.getNodos().get(indicequefortifica).setNumerodesoldados(1);
            
                this.ventana.getPanel().setJ2(j2.getNodos());
                this.ventana.getPanel().repaint();   
            }
            else
            {
            JOptionPane.showMessageDialog(null, "El enemigo no fortifica");
            }
        }
        
        return perder;
    }
    
    public boolean fortificar(int partida, int llegada, int cantidad){
        
        boolean siguienteetapa = false;
        boolean verificado = false;
        boolean  condicion1= false;
        boolean  condicion2= false;
        int indicea=0;
        int indiceb=0;
        
        for(int i=0; i<j1.getNodos().size();i++)
        {
            if(j1.getNodos().get(i).getId()==partida)
            {
                indicea=i;
                condicion1=true;
            }
            else if(j1.getNodos().get(i).getId()==llegada)
            {
                indiceb=i;
                condicion2=true;
            }
        }
        
        if(condicion1==true && condicion2==true )
        {
          verificado = j1.getNodos().get(indicea).buscar(j1.getNodos().get(indiceb).getId());
          
          if(verificado == false)
          {
            JOptionPane.showMessageDialog(null, "El territorio de partida no tiene conexión con el territorio de llegada");
          }
          else 
          {
              
            if((j1.getNodos().get(indicea).getNumerodesoldados()-cantidad)<1)
            {
                  JOptionPane.showMessageDialog(null, "Del territorio "+partida+" al "+llegada+" no puede trasladar mas de "+(j1.getNodos().get(indicea).getNumerodesoldados()-1)+" soldados");
            }
            else if((j1.getNodos().get(indiceb).getNumerodesoldados()+cantidad)<1)
            {
                JOptionPane.showMessageDialog(null, "El territorio de llegada debe contener minimo 1 soldado");
            }
            else
            {
                siguienteetapa = true;
                j1.getNodos().get(indicea).setNumerodesoldados(j1.getNodos().get(indicea).getNumerodesoldados()-cantidad);
                j1.getNodos().get(indiceb).setNumerodesoldados(j1.getNodos().get(indiceb).getNumerodesoldados()+cantidad);
              
                ventana.getPanel().setJ1(j1.getNodos());
                ventana.getPanel().setJ2(j2.getNodos());
                ventana.getPanel().repaint();  
            }   
              
            for(int i=0; i<j1.getNodos().size();i++)
            {
                j1.getNodos().get(i).setVisita(false);
            }
          }
          
          
        }else{
             JOptionPane.showMessageDialog(null, "Uno de los dos territorios no te pertenece");
        }
        
        return siguienteetapa; 
    }
    
    /*El metodo recibe
                    
      Cantidad de soldados en el territorio que ataco
      Cantidad de soldados en el territorio que fue conquistado*/
    
    public boolean balancear(int soldadot1, int soldadot2)
    {
        //Variable que determina si el usuario balanceo de manera correcta
        boolean desbloquear = false;
        
        //Condicion que determina si los datos ingresados son validos para balancear
        if(soldadot1>j1.getNodos().get(indiceatar).getNumerodesoldados() || soldadot1<0 || 
                soldadot2>j1.getNodos().get(indiceatar).getNumerodesoldados() || soldadot2<0 || 
                (soldadot1+soldadot2)!=j1.getNodos().get(indiceatar).getNumerodesoldados() ||
                soldadot1<=0 || soldadot2<=0)
        {
            JOptionPane.showMessageDialog(null, "Los valores ingresados no son un dato valido");
        }
        else
        {
            /* Dato a tener en cuenta
               
            Anteriormente, en el metodo pelear se guardaron los indices de los territorios que participaron
            en la lucha como variables locales de la clase, ahora se da uso de esas variables para reconocer 
            que territorios actualizan la cantidad de soldados */
            
            //El territorio que ataco actualiza la cantidad de soldados que tiene
            j1.getNodos().get(indiceatar).setNumerodesoldados(soldadot1);
            //El territorio que fue conquistado actualiza la cantidad de soldados que tiene
            j2.getNodos().get(indicedefender).setNumerodesoldados(soldadot2);
            
            //Se añade el territorio conquistado a la lista de territorios del jugador 1 (Usuario)
            j1.añadirterritorio(j2.getNodos().get(indicedefender));
            
            /*Al territorio conquistado se le setean los colores por medio del metodo color en la clase jugador
            
            Al metodo se le envia el indice de la lista del jugador donde se encuetra el territorio que se va a actualizar, como el territorio
            que necesita ser seteado de colores acaba de ser añadido esto significa que su indice sera el ultimo de la lista*/
            j1.color(j1.getNodos().size()-1);
            //Se elimina el territorio conquistado de la lista del jugador 2 (Maquina)
            j2.remover(j2.getNodos().get(indicedefender));
            
            //Se actualiza el panel y sus listas
            ventana.getPanel().setJ1(j1.getNodos());
            ventana.getPanel().setJ2(j2.getNodos());
            ventana.getPanel().repaint();
            
            //El usuario balanceo correctamente
            desbloquear = true;
        }
        
        //Retorna la variable que determina si usuario balanceo correctamente
        return desbloquear;
    }
    
    /*El metodo recibe
                    
      Indice del territorio que ataca en la lista 1 (Usuario)
      Indice del territorio que defiende en la lista 2 (Maquina)*/
    
    public boolean pelear(int indiceataca, int indicedefiende){
        
        //Variable que determina si el jugador 1 (Usuario) gano o perdio el enfrentamiento        
        boolean ganar = false;
        
        //Variable que determina cuando termina la fase de atacar
        boolean salir = false;
        
        /*El do-while es la forma en la que los territorios pelean, cada territorio
           va perdiendo de a un soldado, esto sucede hasta que salir = true*/
        do
        {
            //Variable que ayuda a determinar el porcentaje de victoria que tiene cada territorio (en base a los soldados)
            int total = j1.getNodos().get(indiceataca).getNumerodesoldados()+j2.getNodos().get(indicedefiende).getNumerodesoldados();
            
            //Variable que decide quien gana y quien pierde
            int dado = (int) (Math.random()*(total-1)+1);
            
            //Condicion que verifica que territorio gano la lucha
            if(dado<=j1.getNodos().get(indiceataca).getNumerodesoldados())
            {
                //ganan el que ataca
                j2.getNodos().get(indicedefiende).setNumerodesoldados(j2.getNodos().get(indicedefiende).getNumerodesoldados()-1);
            }
            else
            {
                //gana el que defiende
                j1.getNodos().get(indiceataca).setNumerodesoldados(j1.getNodos().get(indiceataca).getNumerodesoldados()-1);
            }
        
            //Si el territorio que ataca perdio tantos soldados hasta llegar a 1 el ataque termina, el jugador 1 (usuario) perdio
            if(j1.getNodos().get(indiceataca).getNumerodesoldados()==1)
            { 
                salir = true;
                JOptionPane.showMessageDialog(null, "Has perdido todos tus soldados :C");
            }
            /*Si el territorio que defiende (el territorio que es atacado) perdio tantos soldados hasta llegar a 0 el ataque termina,
              el jugador 1 (Uusario) gana*/
            else if(j2.getNodos().get(indicedefiende).getNumerodesoldados()==0)
            {
                //El usurio gano
                ganar=true;
                salir = true;
                JOptionPane.showMessageDialog(null, "Has conquistado el territorio");
                
                //Existen variables locales que guardaran los indices de los territorios que participaron en la lucha
                this.indiceatar = indiceataca;
                this.indicedefender = indicedefiende;
            }
                    
        }while(salir==false);
        
        //Se actualiza el panel y sus listas
        ventana.getPanel().setJ1(j1.getNodos());
        ventana.getPanel().setJ2(j2.getNodos());
        ventana.getPanel().repaint();
        
        //Se retorna la variable que identifica si el jugador 1 (Usuario) gano o perdio
        return ganar;

    }
    
    /* El metodo recibe 
    
        Indice del territorio que atacara
        Indice del territorio que defiende (a quien va a atacar) */
    
    public boolean atacar(int territorioataca, int territoriodefiende){
        
        //Variable que determina si el jugador 1 (Usuario) gano o perdio el enfrentamiento
        boolean ganar = false;
        
        //variable que identifica si el territorio que ataca pertenece al jugador
        //¿El territorio le pertenece al jugador?
        boolean ataca = false;
        
        //variable que identifica si el territorio que defiende pertenece al enemigo
        //¿El territorio le pertenece al enemigo?
        boolean defiende = false;

        //variable auxiliar que guarda el indice del territorio que esta en la lista del jugador 1 (Usuario)
        int indiceataca=0;
        
        //variable auxiliar que guarda el indice del territorio que defiende que esta en la lista del jugador 2 (Maquina)
        int indicedefiende=0;
        
        //Se recorre la lista de territorios del jugador 1 (Usuario) en busca del territorio (territorio que ataca) ingresado
        for(int i=0; i<j1.getNodos().size();i++)
        {
            //Condicion que comprueba si el territorio se encuentra en la lista
            if(j1.getNodos().get(i).getId()==territorioataca)
            {
                //Se guarda el indice donde se encuentra el territorio en la lista del jugador 1 (Usuario)
                indiceataca = i;
                //El territorio si le pertenece al jugador 1 (Usuario)
                ataca = true;
            }
        }
        
        //Se recorre la lista de territorios del jugador 2 (Maquina) en busca del territorio (territorio que va a ser atacado) ingresado
        for(int i=0; i<j2.getNodos().size();i++)
        {
            //Condicion que comprueba si el territorio se encuentra en la lista
            if(j2.getNodos().get(i).getId()==territoriodefiende)
            {
                //Se guarda el indice donde se encuentra el territorio en la lista del jugador 2 (Maquina)
                indicedefiende = i;
                //El territorio si le pertenece al jugador 2 (Maquina)
                defiende = true;
            }
        }
        
        /*Condicion que verifica que el territorio que ataca le pertenesca al usuario y 
          el territorio que va a ser atacado le pertenesca a la maquina*/
        if(ataca==true && defiende==true)
        {
            //Si el territorio tiene solo un soldado no ataca
            if(j1.getNodos().get(indiceataca).getNumerodesoldados()>1)
            {
                //Variable que identifica si el territorio que ataca es vecino del territorio que defiende
                boolean atacamos = false;
        
                //Recorreos la lista de vecinos del territorio que ataca
                for(int i=0;i<j1.getNodos().get(indiceataca).getVecinos().size();i++)
                {
                    //Si en la lista de vecinos esta el territorio que defiende ataca de lo contrario no
                    if(j1.getNodos().get(indiceataca).getVecinos().get(i).getId()==territoriodefiende)
                    {
                        //El territorio que va a ser atacado si es vecino del territorio que va a atacar
                        atacamos = true;
                    }
                }
                      
                //Condicion que identifica si los territorios son vecinos
                if(atacamos==true)
                {             
                    /*Llamado al metodo pelear de la clase Modelo (Se hizo de esta manera para trabajar de forma mas comoda)
                      El metodo retorna un boolean que determina si el jugados 1 (Usuario) gano o perdio el enfrentamiento
                    
                    Al metodo se le envia:
                    
                    Indice del territorio que ataca en la lista 1 (Usuario)
                    Indice del territorio que defiende en la lista 2 (Maquina)*/
                    
                    ganar = pelear(indiceataca, indicedefiende);            
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Los territorios deben ser vecinos");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No puedes atacar con solo un soldado");
            }
        }
        else if(ataca==false)
        {
            JOptionPane.showMessageDialog(null, "El territorio que ataca no le pertenece");
        }
        else if(defiende==false)
        {
            JOptionPane.showMessageDialog(null, "El territorio que defiende le pertenece");
        }
        
        //Se retorna la variable que identifica si el jugador 1 (Usuario) gano o perdio
        return ganar;
    }
    
    public void refuerzos(){
               
        int nuevossoldados = j1.getNodos().size();
        JOptionPane.showMessageDialog(null, "Has recibido "+nuevossoldados+" soldados");
        ventana.label2.setText(""+nuevossoldados);
    }
    
    /* El metodo recibe 
    
        La nueva cantidad de soldados disponibles
        El indice del territorio que desea fortalecer
        La cantidad de soldados que desea ingresar en el territorio */
    
    public boolean planificar(int reservas, int indice, int cantidad){

        //Se supone desde el inicio que el usuario ingreso un territorio que no le corresponde
        boolean siguiente = false;
        
        //for que ecorre la lista de territorios que posee el jugador 1 (Usuario)
        for(int i=0; i<j1.getNodos().size();i++)
        {
            //Condicion que indica si el territorio ingresado se encuentra en la lista del jugador
            if(j1.getNodos().get(i).getId()==indice)
            {
                //se actualiza la cantidad de soldados del territorio (soldados actual + cantidad)
                j1.getNodos().get(i).setNumerodesoldados(j1.getNodos().get(i).getNumerodesoldados()+cantidad);
                
                //el territorio si le pertenece
                siguiente = true;
                
                //actualizacion de vista y panel
                ventana.label2.setText(""+(reservas-cantidad));
                ventana.getPanel().setJ1(j1.getNodos());
                ventana.getPanel().repaint();
                
                //se rompe el for
                i=j1.getNodos().size();       
            }
        }   
        
        //Se retorna la variable siguiente
        return siguiente;
    }
    
    public void crearjugador(){
        
        ArrayList<Territorio> copia = territorio;
        
        for(int i=0; i<11;i++)
        {
            int indice = (int) (Math.random()*(copia.size()-1)+1);
            j1.añadirterritorio(copia.get(indice));
            j1.color(i);
            copia.remove(indice);
        }
        
        for(int i=0; i<copia.size();i++)
        {
            j2.añadirterritorio(copia.get(i));
            j2.color(i);
        }

        
        ventana.getPanel().setJ1(j1.getNodos());
        ventana.getPanel().setJ2(j2.getNodos());
        ventana.getPanel().repaint();   
        
        JOptionPane.showMessageDialog(null, "ERES EL EQUIPO AZUL, BUENA SUERTE");
    }
    
    public void creargrafo(){
        
        for(int i=0; i<22; i++ )
        {
            int soldados = (int) (Math.random()*(4-1)+1);
            Territorio t = new Territorio(i,soldados);
            territorio.add(t);
        }
        
        territorio.get(0).agregarvecino(territorio.get(1));
        territorio.get(0).agregarvecino(territorio.get(6));
        territorio.get(0).agregarvecino(territorio.get(15));
        territorio.get(0).coordenadas(250, 120);
        
        territorio.get(1).agregarvecino(territorio.get(2));
        territorio.get(1).coordenadas(250, 210);
        
        territorio.get(2).agregarvecino(territorio.get(3));
        territorio.get(2).coordenadas(210, 295);
        
        territorio.get(3).agregarvecino(territorio.get(4));
        territorio.get(3).agregarvecino(territorio.get(5));
        territorio.get(3).agregarvecino(territorio.get(21));
        territorio.get(3).coordenadas(290, 460);
        
        territorio.get(4).agregarvecino(territorio.get(5));
        territorio.get(4).coordenadas(320, 350);
          
        territorio.get(5).agregarvecino(territorio.get(11));
        territorio.get(5).coordenadas(350, 420);
        
        territorio.get(6).agregarvecino(territorio.get(7));
        territorio.get(6).coordenadas(460, 60);
        
        territorio.get(7).agregarvecino(territorio.get(8));
        territorio.get(7).agregarvecino(territorio.get(9));
        territorio.get(7).coordenadas(545, 110);
        
        territorio.get(8).agregarvecino(territorio.get(9));
        territorio.get(8).agregarvecino(territorio.get(10));
        territorio.get(8).coordenadas(515, 170);
        
        territorio.get(9).agregarvecino(territorio.get(10));
        territorio.get(9).agregarvecino(territorio.get(15));
        territorio.get(9).coordenadas(635, 110);
          
        territorio.get(10).agregarvecino(territorio.get(11));
        territorio.get(10).agregarvecino(territorio.get(14));
        territorio.get(10).agregarvecino(territorio.get(15));
        territorio.get(10).coordenadas(625, 225);
        
        territorio.get(11).agregarvecino(territorio.get(12));
        territorio.get(11).agregarvecino(territorio.get(14));
        territorio.get(11).coordenadas(620, 365);
          
        territorio.get(12).agregarvecino(territorio.get(13));
        territorio.get(12).agregarvecino(territorio.get(14));
        territorio.get(12).coordenadas(720, 470);
        
        territorio.get(13).agregarvecino(territorio.get(19));
        territorio.get(13).coordenadas(675, 565);
          
        territorio.get(14).agregarvecino(territorio.get(15));
        territorio.get(14).agregarvecino(territorio.get(16));
        territorio.get(14).agregarvecino(territorio.get(17));
        territorio.get(14).coordenadas(780, 305);
        
        territorio.get(15).agregarvecino(territorio.get(16));
        territorio.get(15).coordenadas(910, 125);
        
        territorio.get(16).agregarvecino(territorio.get(17));
        territorio.get(16).coordenadas(920, 235);
          
        territorio.get(17).agregarvecino(territorio.get(18));
        territorio.get(17).coordenadas(910, 335);
        
        territorio.get(18).agregarvecino(territorio.get(19));
        territorio.get(18).agregarvecino(territorio.get(20));
        territorio.get(18).coordenadas(1020, 455);
        
        territorio.get(19).agregarvecino(territorio.get(21));
        territorio.get(19).coordenadas(1060, 560);
          
        territorio.get(20).agregarvecino(territorio.get(21));
        territorio.get(20).coordenadas(1145, 435);
        
        territorio.get(21).coordenadas(1165, 545);
        
        crearjugador();
    }

    public jugador getJ1() {
        return j1;
    }
    
}
