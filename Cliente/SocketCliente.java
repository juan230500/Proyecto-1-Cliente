package Cliente;
import java.io.*;
import java.net.*;
public class SocketCliente {
	public static void main(String[] args) throws IOException{
		Socket ClienteSocket = null;
		PrintWriter salida = null;
		BufferedReader entrada = null;
		
		try {
		ClienteSocket = new Socket("localhost", 7777);
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
		BufferedReader entrada1 = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		while((userInput = entrada1.readLine())!=null) {
			salida.println(userInput);
			System.out.println("Cliente:"+entrada.readLine());
		}
		salida.close();
		entrada.close();
		entrada1.close();
		ClienteSocket.close();
	}
}
