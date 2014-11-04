package br.com.schimidtsolutions.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.schimidtsolutions.dto.Usuario;

@Stateless
@LocalBean
public class HelloWorldFacadeServiceBean {

	@Inject
	private HelloWorldServiceBean helloWorldServiceBean;

	public String getHelloWorld(@Valid Usuario usuario) {
		System.out.println("Entrando no EJB HelloWorldFacadeServiceBean...");

		return helloWorldServiceBean.getHelloWorld(usuario);
	}
}
