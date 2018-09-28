/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Socket;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.*;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author reds
 */
public class Cliente {
    private String ip;
    private int puerto;
    public  Cliente(String ip_adress,int puertico){
<<<<<<< HEAD
        ip=ip_adress; 
        puerto=puertico;
    }
    public void enviar(int pos1,int pos2,String name ,int Figura, boolean inicio){
=======
        ip=ip_adress;
        puerto=puertico;
    }
    public void enviar(int pos1,int pos2,String name  ,String figure){
>>>>>>> Pantalla_Inicio
        Envio E1=new Envio();
        E1.setXy1(pos1);
        E1.setXy2(pos2);
        E1.setUser(name);
<<<<<<< HEAD
        E1.setIp(this.ip);
        E1.setInicio(inicio);
       E1.setForma(Figura);
=======
        E1.setIp(ip);
        E1.setInicio(false);
        E1.setDibujo(figure);
>>>>>>> Pantalla_Inicio
        
        try {
              System.out.println(E1.Shipout(E1));
        } 
        catch (JsonProcessingException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket S1;
        try {
            S1 = new Socket(ip,puerto);
            DataOutputStream O1=new DataOutputStream(S1.getOutputStream());       
            O1.writeUTF(E1.Shipout(E1));
            O1.close();
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    public void enviar(String name){
        Envio E1=new Envio();
        E1.setInicio(true);
        E1.setIp(ip);
        E1.setUser(name);
         try {
              System.out.println(E1.Shipout(E1));
        } 
        catch (JsonProcessingException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket S1;
        try {
            S1 = new Socket(ip,puerto);
            DataOutputStream O1=new DataOutputStream(S1.getOutputStream());       
            O1.writeUTF(E1.Shipout(E1));
            O1.close();
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        
        
    }
    
    }
}
