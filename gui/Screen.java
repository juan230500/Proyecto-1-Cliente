/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
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

/**
 *
 * @author reds
 */
public class Screen extends javax.swing.JFrame {
    public Screen(){
    this.Hacer_array();
    }
    //int  Posiciones[]=new  int[36];
    int pos=0;
    
    int  Posiciones[][]=new int[36][2];
    int Colores[][]={{255, 87, 51},{ 255, 195, 0},{93, 173, 226}};
    
    public  void Hacer_puntos(Graphics g){//ESte metodo genera la matriz de puntos visualmente dibujando puntos en el Panel
        
        for (int x =200; x <800; x=x+100) {
            for (int y =100; y <700; y=y+100){
                int random=(int)(Math.random()*3);
                Color Colorcito= new Color(Colores[random][0],Colores[random][1],Colores[random][2]);
                g.setColor(Colorcito);
                g.drawOval(x, y, 50, 50);
                g.fillOval(x+20,y+20,10,10);
                //int Posicion[]={x,y};//ESto genera un array con las posiones x,y del cirulo creado
                //Posiciones[pos]=Posicion;//Guarda el array previo en  uno que contenga todos los de la malla 
                //pos=pos+1;   
            }  
        }

    
}
    public void Hacer_array(){
          for (int x =200; x <800; x=x+100) {
            for (int y =100; y <700; y=y+100){
                int Posicion[]={x,y};//ESto genera un array con las posiones x,y del cirulo creado
                Posiciones[pos]=Posicion;//Guarda el array previo en  uno que contenga todos los de la malla 
                pos=pos+1;   
            }  
        }
    
    
    }
    public void Rellenar_Figura(Graphics g,int xpoints[],int ypoints[],int red,int green , int blue){
        int puntos=xpoints.length;
        Color Colorcito= new Color(red,green,blue);
        g.setColor(Colorcito);
        Polygon p= new Polygon(xpoints,ypoints,puntos);
        g.drawPolygon(p);
        g.fillPolygon(p);
    
    }
    public void dibujar_linea(Graphics g,int x1,int y1,int x2,int y2,int red,int green , int blue){
        Color Colorcito= new Color(red,green,blue);
        g.setColor(Colorcito);
        g.drawLine(x1, y1,x2, y2);
    
    }
    //public  int[][] give_Lista(){
        //System.out.println( Posiciones);
      //  return Posiciones;
    //}

    public  boolean look_position(int mousex,int mousey){//mediante este metodo ingresamos una posicion x,y y nos dice si concuerda con la de un punto de la malla 
        boolean buscador=false;
        boolean buscador2=false;
        for (int x =0; x <=32; x=x+1) {
            if ((Posiciones[x][0]+25)-25<mousex && (Posiciones[x][0]+25)+25>mousex){
                buscador=true;
                break;
            }
           
        }
        for (int y =0; y <=32; y=y+1) {
            if ((Posiciones[y][1]+25)-25<mousey && (Posiciones[y][1]+25)+25>mousey){
                buscador2=true;
                break;
            }
        
           
        }
        if (buscador && buscador2){
            return true;
        
        }
        else{
            return false;
        }
        
        
        //System.out.println( Posiciones);

    }
    
    public  int give_y(int mousey ){//Mediante este metodo nos devuelve la posicon x del centro  del punto mas cercano  para poder dibujar en un futuro desde este 
        for (int y =0; y <=32; y=y+1) {
            if (-5<=((Posiciones[y][1]+25)-mousey)&&((Posiciones[y][1]+25)-mousey)<=5){
                return Posiciones[y][1];
                
            }
           
        }
        return 0;
    }
    public  int give_x(int mousex ){//Mediante este metodo nos devuelve la posicon y del centro del punto mas cercano  para poder dibujar en un futuro desde este 
        for (int x =0; x <=32; x=x+1) {
            if (-5<=((Posiciones[x][0]+25)-mousex)&&((Posiciones[x][0]+25)-mousex)<=5){
                return Posiciones[x][0];  
                
            }
            
        }
        return 0;
    }
    
    
    
}
    
