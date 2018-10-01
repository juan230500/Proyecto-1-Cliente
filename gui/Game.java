/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import principal.Cliente;
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
import adt.*;

import com.fasterxml.jackson.databind.JsonMappingException;
/**
* El programa de Game es uan interfaz que mediante datos que le brinda el
* servidor el muestra contenido en la pantalla 
* 
* @author Sahid Rojas Chacon,Juan Pablo Alvarado
* @version 3.0
* 
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
    private boolean Linea;
    boolean movimiento=false;
    private Screen Screen =new Screen();
    private Server oyente1=new Server(9998);
    private long t;
    private   LinkedQueue  figuras=new LinkedQueue ();
    private int puntos=0;
    

    /**
     * Creates new form Game
     */
    public Game(String myip,String Nombre,int puerto,boolean inicio) {
        ip=myip;//Establezco mi ip para que el servidor  sepa donde responder 
        Username=Nombre;//se establezca un nombre de usuario para que se vea mas elegante la interfaz
        Puerto=puerto;//Se define  que 
        Turno=inicio;
        int x[]={0,1,2};
        int y[]={4,5,6};
        Polygon dato=new Polygon(x,y,3);
        t=System.currentTimeMillis();
        final Cliente User=new Cliente("192.168.100.10",Puerto);
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
              if (Turno){xbegin=xfinal= e.getX();//Mediante este procedimiento se  obtiene la poscion del mouse y se guarada en una variable
              ybegin=yfinal=e.getY();}
              else{
              xbegin=-10;
              ybegin=-20;
              }     
              System.out.println("X = "+ e.getX()+" ; Y = "+e.getY());
           } public void mouseReleased(MouseEvent e){
               System.out.println(Turno);
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
                  
                  if ( Turno && System.currentTimeMillis()-t>100){
                  jLabel1.setText("Es my turno");
                  User.enviarps(Xy1, Xy2, Username,true,"");
              //Screen.dibujar_linea(Panel1, centro1x, centro1y, centro2x,centro2y, 200,10, 19);
              System.out.println("Ya voy a empezar a escuchar");
              Envio Datos=oyente1.escuchar();
              if (!Datos.isEscucha()){
                  puntos+=Datos.getXy1();
                      try {
                          System.out.println("este es ekl shipout"+Datos.Shipout());
                      } catch (JsonProcessingException ex) {
                          Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  String info=Integer.toString(puntos);;
                  jLabel3.setText(info);
                  dibujo(Datos,"Rojo");
                  Datos=oyente1.escuchar();
                }
                 puntos+=Datos.getXy1();
                  System.out.println(Datos.getXy1());
                  String info=Integer.toString(puntos);;
                  jLabel3.setText(info);
                  dibujo(Datos,"Rojo");
              jLabel1.setText("NO es my turno");
              dibujo(Datos,"Verde");
              System.out.println("Aqui ya hago lo que me dice el server");
              Turno=Datos.isEscucha();
              System.out.println("Turno2 "+ Turno);
              Linea=false;
              t=System.currentTimeMillis();
              }
              else{
               jLabel1.setText("es my turno");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 12, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Puntaje");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 812, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("0");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 852, -1, -1));

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
/**
     *Este metodo es un evento que se ejecuta cuando la pantalla se activa
     *por primera vez
     * 
     */
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
         Graphics Panel1=jPanel1.getGraphics();
        Screen.Hacer_puntos(Panel1);
        if (!Turno){
         System.out.println("NO es my turno estoy esperando");
         Envio Datos=oyente1.escuchar();
         dibujo(Datos,"Verde");
        
         //System.out.println();
         Turno=true;
         Linea=true;
         System.out.print("ya recibi algo por primera vez");
         
        }        
    }//GEN-LAST:event_formWindowActivated
/**
     *Este metodo recibe un paquete de envio y analiza el valor del atributo
     *dibujo para ver si tiene que dibujar algo y su tiene que dibujar algi si es una linea o una figura 
     * 
     */
    private void dibujo(Envio Datos,String Color){
    int color[];
    Graphics Panel1=jPanel1.getGraphics();
    int color1[]={254,0,0};
    int color2[]={0,254,0};
     if (Color.equals("Rojo")){
    color=color1;
        try {
            System.out.println(Datos.Shipout());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     else{
         
     color=color2;
     }System.out.println(Datos.getDibujo());
        if (Datos.getDibujo().equals("Linea")){
             int[] xpos=Datos.getXpos();
             int[] ypos=Datos.getYpos();
             System.out.println("voiy a dibujar unalinea");
             Screen.dibujar_linea(Panel1, ((xpos[0]+2)*100)+25,((ypos[0]+1)*100)+25, ((xpos[1]+2)*100)+25, ((ypos[1]+1)*100)+25, color[0],color[1],color[2]);
              }
        if (Datos.getDibujo().equals("Dibujo")){
            //figuras.insertar();
            System.out.println("voiy a dibujar unaFigura");
            int[] xpos=Datos.getXpos();
            int[] ypos=Datos.getYpos();
            //Screen.Rellenar_Figura(Panel1, xpos, ypos,color[0],color[1],color[2]);
            Screen.Rellenar_Figura(Panel1, xpos, ypos,color[0],color[1],color[2]);
              }

}
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
