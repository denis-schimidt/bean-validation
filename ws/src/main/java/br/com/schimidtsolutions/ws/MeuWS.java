package br.com.schimidtsolutions.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.validation.Valid;

import br.com.schimidtsolutions.dto.Usuario;
import br.com.schimidtsolutions.ejb.HelloWorldServiceBean;
import br.com.schimidtsolutions.ws.exception.InputParameterException;
import br.com.schimidtsolutions.ws.exception.WsInputExceptionFault;

@WebService
public class MeuWS {

	@Inject
	private HelloWorldServiceBean service;

	@WebMethod
	@Valid
	public String getHelloWorld(Usuario usuario) throws WsInputExceptionFault {

		if (true) {
			throw new WsInputExceptionFault("Erro!",
					new InputParameterException("Usuario Inválido!"));
		}

		return service.getHelloWorld(usuario);
	}
}
