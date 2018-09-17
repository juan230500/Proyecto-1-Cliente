/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;//El paquete a ulizar 
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Polygon;
//se importan las librerias necesarias para el manejo de la interfaz grafica
/**
 *
 * @author reds
 */

public class Game_Screen extends javax.swing.JFrame {
    private int xbegin=0;
    private int ybegin=0;
    private int yfinal=0;
    private int xfinal=0;
    int xpoints[] = {425,425,525};
    int ypoints[] = {325, 425, 325};
    private int point_counter=1;
    private int line_counter=1;
    private String Pointname1;
    private String Pointname2;
    private String Linename;
    boolean condicion=false;
    
    boolean movimiento=false;
    private Screen Screen =new Screen();
    int button_X_Pos;
    int button_Y_Pos;
    // se crean las variables que se van a utilizar en esta parte grafica 
    

    /**
     * Creates new form Game_Screen
     */
   
    public Game_Screen() {//este es el metodo principal en el cual se manejan los componentes y su logica el cual es llamado en el main
        initComponents();
        Graphics Panel1=jPanel1.getGraphics();
        Screen.Rellenar_Figura(Panel1,xpoints,ypoints,0,255,0);
        if ( condicion==false){
            
            Panel1.setColor(Color.red);
        Panel1.drawLine(200, 300, 400, 500);
        }
        jPanel1.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent e){//ESte metodo se ejecuta cuando el mouse se presiona en algun lado de la pantalla 
              xbegin=xfinal= e.getX();//Mediante este procedimiento se  obtiene la poscion del mouse y se guarada en una variable
              ybegin=yfinal=e.getY();
              condicion=true;
              System.out.println("X = "+ e.getX()+" ; Y = "+e.getY());
           }
          public void mouseReleased(MouseEvent e){//Este metodo se ejecuta cuando el mouse se deja de presionar
              xfinal= e.getX();//Mediante este  metodo se recolecta la posicion del mouse cuando se deja de presionar para sabe la posicion final
              yfinal=e.getY();
              Graphics Panel1=jPanel1.getGraphics();//Mediante esto se crea un objeto grafico para poder dibujar en el panel 1
              //Screen.Rellenar_Figura(Panel1,xpoints,ypoints,0,255,0);
//Este condicional lo que valida es que cuando se presiona el mouse incialmete este en un punto y cuando se suelte tambie  sea en un punto de la matriz y mediante la variable  movimiento sabemos que no es le mismo punto ambos
              if(Screen.look_position(xbegin, ybegin)&& Screen.look_position(xfinal, yfinal) && movimiento ){
                    if(Screen.give_x(xbegin)!=0&& Screen.give_x(xfinal)!=0 && Screen.give_y(ybegin)!=0 && Screen.give_y(yfinal)!=0){
                        int centro1x=Screen.give_x(xbegin);
                        int centro1y=Screen.give_y(ybegin);
                        int centro2x=Screen.give_x(xfinal);
                        int centro2y=Screen.give_y(yfinal); 
                        jLabel4.setText("");
                        if((Math.abs(centro1x-centro2x)==100 && Math.abs(centro1y-centro2y)<=100)||(Math.abs(centro1y-centro2y)==100 &&  Math.abs(centro1x-centro2x)<=100)){
                            jLabel4.setText("");
                           Panel1.setColor(Color.GREEN);
                           Pointname1 = "Punto" + point_counter;
                           Pointname2 = "Punto" + point_counter+1;
                           Linename="Linea"+line_counter;
                           Punto Pointname1 = new Punto(centro1x,centro1y);
                           Punto Pointname2 = new Punto(centro2x,centro2y);
                           Linea Linename=new Linea(Pointname1,Pointname2);
                          //Esta linea dibuja una linea de el centro de un punto al otro
                          //Punto=new Punto(centro1,centro2);
                          Panel1.drawLine(Screen.give_x(xbegin)+25, Screen.give_y(ybegin)+25, Screen.give_x(xfinal)+25,Screen.give_y(yfinal)+25);
                            
                        }
                        else{
                            jLabel4.setText(Math.abs(centro1y-centro2y)+"Lo sentimos usted solo puede unir puntos adyacentes "+Math.abs(centro1x-centro2x));
                            
                        }
                          
                      }
                      
                      System.out.println(Screen.give_x(xbegin)+", el x inicial es ese  y el final es "+Screen.give_x(xfinal));
                      System.out.println(Screen.give_y(ybegin)+", el y inicial es ese  y el final es "+Screen.give_y(yfinal));
                  }
              else{
                  jLabel4.setText("Lo sentimos usted no selecciono puntos validos.Intentelo de nuevo");
                  
              }
              
              
                  //Este condicional valida si el punto cuando se suelta el mouse es un punto de la   matriz y si se movio ya que puede que se solto el mouse pero no se movio ahi es donde funciona la varibale movimiento
                  
                      //ESte condicional lo que verifica cual es  el centro del punto que se toco para que ala hora de dibujar se parta del centro de el punto y no de un punto cualquiera dentro de este 
                      
            
             //Se establece la variabble de movimiento falsa ya que cuando se suelta el mouse ya termino de mover este  
              movimiento=false;

              System.out.println("X = "+ e.getX()+" ; Y = "+e.getY());
           }
         }
        
        );
        jPanel1.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){//ESte metodo  cuando se atrastra el mouse de una posion a otra 
              Graphics Panel1=jPanel1.getGraphics();
              movimiento=true;//se establece que la varaiable movimiento es verdadera ya que sabemos que este metodo se ejecuta cuando se arastra el mouse
           }
        });
        Screen.Rellenar_Figura(Panel1,xpoints,ypoints,0,255,0);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(46, 37, 37));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("TU PUNTAJE  ACTUAL");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("0");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("PUNTAJE ENEMIGO");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("0");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 165, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 651, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // ESte metodo se ejecuta cuando la pantalla se abre incialmente y lo ulizamos para crear la malla de puntos cuando se inicia el programa 
        Graphics Panel1=jPanel1.getGraphics();
        Screen.Hacer_puntos(Panel1);
   
    }//GEN-LAST:event_formWindowActivated

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
 
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        
       
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
                 
    }//GEN-LAST:event_jPanel1MousePressed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        
        
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game_Screen().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

