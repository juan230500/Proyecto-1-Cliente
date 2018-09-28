/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Socket;
import javax.swing.*;
<<<<<<< HEAD
import java.awt.*;
import java.net.*;
import adt.List;
import java.io.DataInputStream;
import java.io.IOException;
=======

import java.awt.*;

import java.net.*;
import adt.List;

import java.io.DataInputStream;
import java.io.IOException;

>>>>>>> Pantalla_Inicio
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
=======

>>>>>>> Pantalla_Inicio
/**
 *
 * @author reds
 */
public class Servidor implements Runnable{
<<<<<<< HEAD
    private  String Informacion;
    private ServerSocket server;
    //private int Puerto;
    public Servidor (int numero){
        try {
            server=new ServerSocket(numero);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String escuchar(){
            Thread hilo= new Thread(this);
	    hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Informacion;
=======
    private  String Texto;
    private int Puerto;
    static ServerSocket server;
    private static  Envio e1=new Envio();
    
public Envio Dame_Datos(){
   return e1;
}
    public String getTexto() {
        
        return Texto;
    }
    
    public Servidor (int Puerto){
        this.Puerto=Puerto;
    }
    public void escuchar(){
            Thread hilo= new Thread(this);
		
	    hilo.start();
            
        
        
>>>>>>> Pantalla_Inicio
        }

    @Override
    public void run() {
        		try {
                        String condicion ="";
<<<<<<< HEAD
			
			while (condicion=="") 
                        {
			Socket misocket=server.accept();
			DataInputStream I0=new DataInputStream(misocket.getInputStream());
			String mensaje=I0.readUTF();
                        Informacion = mensaje;
                         Envio e1=new Envio();
			e1.Shipin(mensaje);
                        if ((e1.isEscucha())){
                        condicion="exit";
                        //System.out.println("se cumplio el if "+e1.getXy1());
                        }
			misocket.close();
			try {
				Thread.sleep(0);
=======
			ServerSocket server=new ServerSocket(Puerto);
			while (condicion=="") 
                        {
                       
			Socket misocket=server.accept();
			
			DataInputStream I0=new DataInputStream(misocket.getInputStream());
			
			String mensaje=I0.readUTF();
			
			//areatexto.append("\n"+mensaje);
			
			
                        
			
			e1.Shipin(mensaje);
                        if (!(e1.getDibujo().equals(""))){
                        
                        condicion="exit";
                        System.out.println("se cumplio el if "+e1.getXy1());
                        }
                        /*if (e1.isInicio()){
                        areatexto.append("Ha ingresado el usuario con el nombre de "+e1.getUser());
                        }
			else{
                        areatexto.append("\nla xy1 es "+e1.getXy1()+"el xy2 es "+e1.getXy2()+"y fue realizado por "+e1.getUser());

                        }*/
			
			misocket.close();
			
			try {
				Thread.sleep(1000);
>>>>>>> Pantalla_Inicio
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
<<<<<<< HEAD
=======
                        //this.Dame_Datos();
                        //System.out.print("ya deje de escuchar");
			
>>>>>>> Pantalla_Inicio
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
<<<<<<< HEAD
=======

 

>>>>>>> Pantalla_Inicio
}
