package test.test;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HelloWorldImpl implements HelloWorld {

	private final String message = "Olá, ";

	@Override
	public String sayHi(@WebParam(name = "nome") String text) {
		return message + text + ".";
	}

	@Override
	public String sayHiToUser(@WebParam(name = "usuario") User user) {
		return sayHi(user.getName());
	}
}
