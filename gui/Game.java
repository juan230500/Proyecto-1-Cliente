/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.net.*;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import NET.*;
import com.fasterxml.jackson.databind.JsonMappingException;
/**
 *
 * @author reds
 */
public class Game extends javax.swing.JFrame {
//********************Aqui se establecen los atributos que se van a utlitzar***********************************************************************
    private int xbegin=0;
    private int ybegin=0;
    private int yfinal=0;
    private int xfinal=0;
    private String ip;
    private int Puerto;
    private String ip_server="192.168.100.22";
    private String Username;
    private  boolean  Turno;
    boolean movimiento=false;
    private Screen Screen =new Screen();
    private Server oyente1=new Server(9998);

    /**
     * Creates new form Game
     */
    public Game(String myip,String Nombre,int puerto,boolean inicio) {
        ip=myip;//Establezco mi ip para que el servidor  sepa donde responder 
        Username=Nombre;//se establezca un nombre de usuario para que se vea mas elegante la interfaz
        Puerto=puerto;//Se define  que 
        Turno=inicio;
        initComponents();
        if (!Turno){
            jLabel1.setText("NO es my turno");
        
        }
        else{
         jLabel1.setText("Es my turno");
        }
       
        //Graphics Panel1=jPanel1.getGraphics();
         jPanel1.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent e){//ESte metodo se ejecuta cuando el mouse se presiona en algun lado de la pantalla 
              xbegin=xfinal= e.getX();//Mediante este procedimiento se  obtiene la poscion del mouse y se guarada en una variable
              ybegin=yfinal=e.getY();

              System.out.println("X = "+ e.getX()+" ; Y = "+e.getY());
           } public void mouseReleased(MouseEvent e){
           xfinal= e.getX();//Mediante este  metodo se recolecta la posicion del mouse cuando se deja de presionar para sabe la posicion final
              yfinal=e.getY();
              Graphics Panel1=jPanel1.getGraphics();
              if(Screen.look_position(xbegin, ybegin)&& Screen.look_position(xfinal, yfinal) && movimiento ){
              if(Screen.give_x(xbegin)!=0&& Screen.give_x(xfinal)!=0 && Screen.give_y(ybegin)!=0 && Screen.give_y(yfinal)!=0){
              int centro1x=Screen.give_x(xbegin);
                        int centro1y=Screen.give_y(ybegin);
                        int centro2x=Screen.give_x(xfinal);
                        int centro2y=Screen.give_y(yfinal); 
                        int Xy1=((centro1x-200)/10)+((centro1y-100)/100);
                        int Xy2=((centro2x-200)/10)+((centro2y-100)/100);
                        if((Math.abs(centro1x-centro2x)==100 && Math.abs(centro1y-centro2y)<=100)||(Math.abs(centro1y-centro2y)==100 &&  Math.abs(centro1x-centro2x)<=100)){
                        
                        int Puerto=9987;       
                        Cliente User=new Cliente("192.168.100.10",Puerto);
                        User.enviarps(Xy1, Xy2, Username,true,"");
                        System.out.println("Ya voy a empezar a escuchar");
                        Envio Datos=oyente1.escuchar();
                        System.out.println("Aqui ya hago lo que me dice el server");
                          //System.out.println(Informacion);
                        if(Datos.isEscucha()){
                        jLabel1.setText("repita la linea men");
                        }
                        if(!Datos.isEscucha()){
                        Datos=oyente1.escuchar();
                            try {
                                System.out.println(Datos.Shipout());
                            } catch (JsonProcessingException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        }
              }
              }
           }
         }
        );
         jPanel1.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){//ESte metodo  cuando se atrastra el mouse de una posion a otra 
              Graphics Panel1=jPanel1.getGraphics();
              movimiento=true;//se establece que la varaiable movimiento es verdadera ya que sabemos que este metodo se ejecuta cuando se arastra el mouse
           }
        });
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(46, 37, 37));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(964, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(988, Short.MAX_VALUE))
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
        // TODO add your handling code here:
         Graphics Panel1=jPanel1.getGraphics();
        Screen.Hacer_puntos(Panel1);
        if (!Turno){
         System.out.println("NO es my turno estoy esperando");
         Envio Datos=oyente1.escuchar();
         
         //System.out.println();
         Turno=true;
        }
        
        
        
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game("172.19.49.45","Reds",9987,true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
