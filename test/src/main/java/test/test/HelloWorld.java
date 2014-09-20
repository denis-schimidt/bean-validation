package test.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorld {

	@WebMethod
	String sayHi(@WebParam(name = "nome") String text);

	@WebMethod
	String sayHiToUser(@WebParam(name = "usuario") User user);
}