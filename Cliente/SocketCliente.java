package Cliente;
import java.io.*;
import java.net.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Interfaz.*;
public class SocketCliente {
		Socket ClienteSocket = null;
		PrintWriter salida = null;
		BufferedReader entrada = null;
		int n = 7777;
	public void start() throws IOException {
		try {
		ClienteSocket = new Socket("localhost", n);
		}
		catch(UnknownHostException error) {
			System.err.println("Host desconocido");
			System.exit(1);
		}
		catch(IOException error) {
			System.err.println("No se puede conectar al host");
			System.exit(1);
		}
		//BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public void enviar(Envio data) throws IOException {
		salida = new PrintWriter(ClienteSocket.getOutputStream(),true);	
		salida.println(Shipout(data));
		System.out.println(Shipout(data)); //...
	}
	public Respuesta recibir() throws IOException {
		entrada = new BufferedReader(new InputStreamReader(ClienteSocket.getInputStream()));
		String inputline = entrada.readLine();
		return Ansin(inputline);
		System.out.println(Ansin(inputline)); //para llevar control de lo que se envia
	

	}
	public static String Ansout(Respuesta e) throws JsonProcessingException {
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
	public static String Shipout(Envio e) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
			json = mapper.writeValueAsString(e);
		return json;
	}
	public static Envio Shipin(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Envio e = mapper.readValue(json, Envio.class);
		return e;
		
	}
	public void close() throws IOException {
		salida.close();
		entrada.close();
		ClienteSocket.close();
	}
	
}

