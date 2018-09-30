package NET;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

public class pruebas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] a= {2};
		Envio e=new Envio(a,a,"g",true);
		String json=e.Shipout();
		System.out.println(json);
		
		Envio e1=new Envio();
		e1.Shipin(json,false);
		System.out.println(e.Shipout());

	}

}
