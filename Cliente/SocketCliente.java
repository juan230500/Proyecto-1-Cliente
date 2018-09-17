package Cliente;
import java.io.*;
import java.net.*;
import geo.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SocketCliente {
		Socket ClienteSocket = null;
		PrintWriter salida = null;
		BufferedReader entrada = null;
		int n = 7777;
	public void start() {
		try {
		ClienteSocket = new Socket("localhost", n);
		salida = new PrintWriter(ClienteSocket.getOutputStream(),true);
		entrada = new BufferedReader(new InputStreamReader(ClienteSocket.getInputStream()));
	
		}
		catch(UnknownHostException error) {
			System.err.println("Host desconocido");
			System.exit(1);
		}
		catch(IOException error) {
			System.err.println("No se puede conectar al host");
			System.exit(1);
		}
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		while((userInput = entrada.readLine())!=null) {
			salida.println(userInput);
			System.out.println("Cliente1:"+entrada.readLine());
		}
		
	}
	public static String Ansout(Respuesta e)JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
			json = mapper.writeValueAsString(e);
		return json;
	}
	public static Respuesta Ansin(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Respuesta a = mapper.readValue(json, Respuesta.class);
		return a;
	}
	public static String Shipout(Envio e)JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
			json = mapper.writeValueAsString(e);
		return json;
	}
	public static Envio Shipin(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Envio e = mapper.readValue(json, Respuesta.class);
		return e;
	}
	public void close() {
		salida.close();
		entrada.close();
		entrada1.close();
		ClienteSocket.close();
	}
	
}

