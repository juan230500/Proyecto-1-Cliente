/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Socket;
import javax.swing.*;

import java.awt.*;

import java.net.*;
import adt.List;

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
            
        
        
        }

    @Override
    public void run() {
        		try {
                        String condicion ="";
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
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
                        //this.Dame_Datos();
                        //System.out.print("ya deje de escuchar");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 

}
