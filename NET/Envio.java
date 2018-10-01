/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NET;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

/**
 *
*  El programa de Envio  su funcionalidad es  crear un objeto con los datos necesarios
* para que el Servidor y el Cliente se comuniquen de manera efectiva y mediante este se tranfieran
* toda la informacion necesaria
* @author Sahid Rojas Chacon,Juan Pablo Alvarado
* @version 3.0
 */
public class Envio {
	private int xy1;
    private int xy2;
    private boolean Inicio;
    private String User;
    private String Ip;
    private int[] xpos;
    private int[] ypos;
    private String Dibujo;
    private boolean escucha;
	
	//Objeto envio en limpio
    /**
          * Constructor de  un paquete envio limpio.
           * 
           * 
           */
		public Envio() {
			this.xy1=0;
	        this.xy2=0;
	        this.Inicio=false;
	        this.User=null;
	        this.Ip=null;
	        this.xpos = null;
			this.ypos = null;
			Dibujo = null;
			this.escucha = false;
		}
		
		//-----------------Cliente
                /**
           * Constructor que usa cuando se envia algo desde el cliente  al servidor.
           * @param  co1  Este paraetro espera las cordenas Xy1.
           * @param co2 Este parametro espera las cordenadas Xy2.
           * @param inicio Este parametro es un true si se lo envia por primera vez o false si es una segunda .
           * @param user Este parametro brinda el Nombre del usuario.
           * @param ip Mediante este parametro se sabe desde que ip se esta enviando el Envio 
           *  
           * 
          */
                
	    public Envio(int co1,int co2, boolean inicio, String user, String ip){
	        this.xy1=co1;
	        this.xy2=co2;
	        this.Inicio=inicio;
	        this.User=user;
	        this.Ip=ip;
	        //Valores en null
	        this.xpos = null;
			this.ypos = null;
			this.Dibujo = null;
			this.escucha = false;
	    }
	    
	    //-----------------Servidor
           /**
           * Constructor que usa cuando se envia algo desde el servidor al cliente  .
           * @param  xpos  Este parametro establece el array de las posiciones de x para dibujar .
           * @param  ypos  Este parametro establece el array de las posiciones de y para dibujar .
           * @param dibujo Este parametro estable que dibujo queremos que  el cliente muestre.
           * @param escucha Mediante este parametro podemos establecer si queremos que el cliente siga escuchando o pare.
           */
	    public Envio(int[] xpos, int[] ypos, String dibujo, boolean escucha) {
			this.xpos = xpos;
			this.ypos = ypos;
			this.Dibujo = dibujo;
			this.escucha = escucha;
			//Valores en null
		this.xy1=0;
	        this.xy2=0;
	        this.Inicio=false;
	        this.User=null;
	        this.Ip=null;
		}


	/**
	 * Metodo que serializa un objeto de la clase Envio en formato JSON como String
	 * @param e Objeto de la clase Envio a serializar
	 * @return String en formato JSON
	 * @throws JsonProcessingException Indicador en caso de error
	 */
	 public String Shipout() throws JsonProcessingException{
			ObjectMapper mapper = new ObjectMapper();
			String json;
			json = mapper.writeValueAsString(this);
			return json;
		}
	 /**
	  * Metodo que deserializa un String con formato JSON en un objeto de la clase Envio
	  * @param json String en formato JSON a deserializar
	  * @throws JsonParseException Indicador en caso de error
	  * @throws JsonMappingException Indicador en caso de error
	  * @throws IOException Indicador en caso de error
	  */
	 public void Shipin(String json,boolean servidor) throws JsonParseException, JsonMappingException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY);
			Envio e = mapper.readValue(json, Envio.class);
			
			this.xy1=e.getXy1();
	        this.xy2=e.getXy2();
	        this.Inicio=e.isInicio();
	        this.User=e.getUser();
	        this.Ip=e.getIp();
			
			this.xpos = e.getXpos();
			this.ypos = e.getYpos();
			this.Dibujo = e.getDibujo();
			this.escucha = e.isEscucha();
			
			
}


	public int getXy1() {
		return xy1;
	}


	public int getXy2() {
		return xy2;
	}


	public boolean isInicio() {
		return Inicio;
	}


	public String getUser() {
		return User;
	}


	public String getIp() {
		return Ip;
	}


	public int[] getXpos() {
		return xpos;
	}


	public int[] getYpos() {
		return ypos;
	}


	public String getDibujo() {
		return Dibujo;
	}


	public boolean isEscucha() {
		return escucha;
	}

	public void setXy1(int xy1) {
		this.xy1 = xy1;
	}

	public void setXy2(int xy2) {
		this.xy2 = xy2;
	}

	public void setInicio(boolean inicio) {
		Inicio = inicio;
	}

	public void setUser(String user) {
		User = user;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public void setXpos(int[] xpos) {
		this.xpos = xpos;
	}

	public void setYpos(int[] ypos) {
		this.ypos = ypos;
	}

	public void setDibujo(String dibujo) {
		Dibujo = dibujo;
	}

	public void setEscucha(boolean escucha) {
		this.escucha = escucha;
	}
}
