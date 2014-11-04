package br.com.schimidtsolutions.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.schimidtsolutions.dto.Usuario;

@Stateless
@LocalBean
public class HelloWorldServiceBean {

	public String getHelloWorld(Usuario usuario) {
		System.out.println("Entrando no EJB HelloWorldServiceBean...");

		return String.format("Beleza %s com idade de %.0f", usuario.getNome(),
				usuario.getIdade());
	}
}
