package NET;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import adt.List;
/**
* El programa de Server  su funcionalidad es  crear un objeto  server para que el escuche desde 
* cierto puerto especifico para que cuando  un objetocliente le envia este capte ese mensaje
* toda la informacion necesaria
* @author Sahid Rojas Chacon,Juan Pablo Alvarado
* @version 3.0
 */
public class Server implements Runnable {
	private ServerSocket server;
	private int Puerto;
	private  Envio Informacion;
	/**
           * Constructor del server 
           * @param  numero  Este es para estalecer por cual puerto escuchar
          */
	 public Server (int numero){
	        try {
	        	server=new ServerSocket(numero);
	        } catch (IOException ex) {
	            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
         /**
           * Este metodo genera un hilo que espera a que se reciba algo por el server socket
           * ademas de eso el me devuelve un paquete envio para que yo pueda manerjar la informacion
           * 
          */
	    public Envio escuchar(){
	            Thread hilo= new Thread(this);
		    hilo.start();
	        try {
	            hilo.join();
	        } catch (InterruptedException ex) {
	            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return Informacion;}

	    @Override
	    public void run() {
	    	try {
	    		String condicion ="";
	    		 
				Socket misocket=server.accept();
				DataInputStream I0=new DataInputStream(misocket.getInputStream());
				String mensaje=I0.readUTF();
	            Envio e1=new Envio();
                    System.out.println(mensaje);
				e1.Shipin(mensaje,false);
				Informacion=e1;
				misocket.close();
				condicion="exit";
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	}

}
