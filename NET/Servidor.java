/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NET;
import javax.swing.*;

import java.awt.*;
import java.net.*;

import java.io.DataInputStream;
import java.io.IOException;


import java.awt.*;

import java.net.*;
//import adt.List;

import java.io.DataInputStream;
import java.io.IOException;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reds
 */
public class Servidor implements Runnable{

    private  String Informacion;
    private ServerSocket server;
    private  String Texto;
    private int Puerto;
    private static  Envio e1=new Envio();
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
        return Informacion;}

    @Override
    public void run() {
try {
                        String condicion ="";
			
			while (condicion=="") 
                        {
                       
			Socket misocket=server.accept();
			DataInputStream I0=new DataInputStream(misocket.getInputStream());
			String mensaje=I0.readUTF();
                        //Valor=I0.readUTF();
			//areatexto.append("\n"+mensaje);
                        Informacion=mensaje;
			e1.Shipin(mensaje);
                        
                        if (e1.isEscucha()){                              
                        condicion="exit";
                        System.out.println(" hola jeje: "+e1.getIp());
                        }
			misocket.close();
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    }

    

    
}
    