package Cliente;

import java.net.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import Interfaz.Envio;
import Interfaz.Respuesta;

import java.awt.event.*;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class SC2 {

	public static void main(String[] args){
	try {
        Socket S1=new Socket("localhost",9987);
        Envio pack = new Envio();
		pack.setInicio(true);
		pack.setUser("user");
		pack.setXy1(1);
		pack.setXy2(4);
		
        DataOutputStream O1=new DataOutputStream(S1.getOutputStream());
        O1.writeUTF(enviar(pack));
        System.out.println("Cliente envia: "+enviar(pack));
        DataInputStream I0 = new DataInputStream(S1.getInputStream());//inicia
        String mensaje = I0.readUTF();
		System.out.println("Cliente recibe: "+mensaje);//termina
		O1.close();
        S1.close();
        
    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	}
	/**
	 * Serializa y retorna como String en formato JSON a un objeto de la clase Envio
	 * @param e Objeto de la clase Envio que se serializara
	 * @return String en formato JSON del objeto de la clase Envio
	 * @throws JsonProcessingException Indicador de error
	 */
	public static String enviar(Envio e) throws JsonProcessingException {
		return e.Shipout(e);
}
	/**
	 * Deserializa y retorna como objeto de la clase Respuesta a un String en formato JSON
	 * @param a String en formato JSON por deserializar
	 * @return Objeto de la clase Respuesta
	 * @throws JsonParseException Indicador de error
	 * @throws JsonMappingException Indicador de error
	 * @throws IOException Indicador de error
	 */
	public static Respuesta recibir(String a) throws JsonParseException, JsonMappingException, IOException {
		Respuesta e= new Respuesta();
		e.Ansin(a);
		return e;
	}

}