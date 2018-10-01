/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import NET.Envio;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.*;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
* El programa de Cliente su funcionalidad es  crear un objeto Cliente el cual pueda
* enviar datos a un  un ServerSocket mediante un paquete envio;
* @author Sahid Rojas Chacon,Juan Pablo Alvarado
* @version 3.0
 */
public class Cliente {
    private String ip;
    private int puerto;
         /**
           * Constructor del cliente .
           * @param  ip_adress  Este parametro espera se establece la direccion desde la cual se envia
           * @param puertico ESte parametro sirve para saber a cual puerto voy a enviar
           * 
          */
    public  Cliente(String ip_adress,int puertico){

        ip=ip_adress; 
        puerto=puertico;
    }
           /**
           * Este metodo se utiliza cuando el objeto envia para el servidor(ps) .
           * @param  pos1 Es el valor de la posicion XY1 
           * @param pos2 Es el valor de la posicion XY2
           * @param name Se envia el nombre de quien va a realizar el envio
           * @param inicio Se establece la varaible boolena de incion 
           * @param myip Se envia desde cual ip se envia àra que el que reciba sepa a donde responder 
          */
    public void enviarps(int pos1,int pos2,String name , boolean inicio,String myip){

        Envio E1=new Envio(pos1,pos2,inicio,name,myip);
        
        try {
              System.out.println(E1.Shipout());
        } 
        catch (JsonProcessingException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket S1;
        try {
            S1 = new Socket(ip,puerto);
            DataOutputStream O1=new DataOutputStream(S1.getOutputStream());       
            O1.writeUTF(E1.Shipout());
            O1.close();
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
     /**
           * Este metodo se utiliza cuando el objeto envia para el cliente (ps) .
           * @param  xpos Es el valor del array de las posiciones X 
           * @param ypos Es el valor del array  de las posiciones y
           * @param dibujo Se envia el nombre del dibujo para saber que se dibuja
           * @param escucha Se establece la varaible boolena de escucha para que sepa  si debe segui o no escuchando
           *  
          */
    public void enviarpc(int [] xpos,int[] ypos,String dibujo , boolean escucha){

        Envio E1=new Envio(xpos,ypos,dibujo,escucha);
        
        try {
              System.out.println(E1.Shipout());
        } 
        catch (JsonProcessingException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket S1;
        try {
            S1 = new Socket(ip,puerto);
            DataOutputStream O1=new DataOutputStream(S1.getOutputStream());       
            O1.writeUTF(E1.Shipout());
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
