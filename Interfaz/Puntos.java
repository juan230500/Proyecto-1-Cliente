/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
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

/**
 *
 * @author reds
 */
public class Puntos extends javax.swing.JFrame {
    //int  Posiciones[]=new  int[36];
    int pos=0;
    
    int  Posiciones[][]=new int[36][2];
    
    public  void Hacer_puntos(Graphics g){
        
        for (int x =200; x <800; x=x+100) {
            for (int y =100; y <700; y=y+100){
                //g.drawLine(x, y, 800, y);
                //g.drawLine(x+25, y+25, 800, y+25);
                g.drawOval(x, y, 50, 50);
                g.setColor(Color.RED);
                g.fillOval(x+20,y+20,10,10);
                
                int Posicion[]={x,y};
                Posiciones[pos]=Posicion;
                pos=pos+1;   
            }  
        }

    
}
    public  int[][] give_Lista(){
        //System.out.println( Posiciones);
        return Posiciones;
    }
    public void paint(Graphics g,int x1,int y1,int x2,int y2) {
        super.paint(g);
        g.drawLine(x1,y1, x2,y2);
    }
    public  boolean look_position(int mousex,int mousey){
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
    public  boolean look_position_y(int mousey ){
        boolean buscador=false;
        for (int y =0; y <=32; y=y+1) {
            if (Posiciones[y][1]<mousey && Posiciones[y][1]+25+25>mousey){
                buscador=true;
                break;
            }
           
        }
        return buscador;
        
        //System.out.println( Posiciones);

    }
    public  int give_y(int mousey ){
        for (int y =0; y <=32; y=y+1) {
            if (-5<=((Posiciones[y][1]+25)-mousey)&&((Posiciones[y][1]+25)-mousey)<=5){
                return Posiciones[y][1];
                
            }
           
        }
        return 0;
    }
    public  int give_x(int mousex ){
        for (int x =0; x <=32; x=x+1) {
            if (-5<=((Posiciones[x][0]+25)-mousex)&&((Posiciones[x][0]+25)-mousex)<=5){
                return Posiciones[x][0];  
                
            }
            
        }
        return 0;
    }
    
    
    
}
    
