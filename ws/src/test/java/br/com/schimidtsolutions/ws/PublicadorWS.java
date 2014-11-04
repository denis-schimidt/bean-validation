package br.com.schimidtsolutions.ws;

import javax.xml.ws.Endpoint;

public class PublicadorWS {

	public static void main(String[] args) {
		System.out.println("Publicando WS....");
		final MeuWS ws = new MeuWS();
		Endpoint.publish("http://localhost:9080/ws/webservices/meuws", ws);
	}
}
