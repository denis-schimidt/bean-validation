package test.test;

import static org.junit.Assert.assertNotNull;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloTest {

	private HelloWorld client;

	@BeforeClass
	public static void publicarWebService() {
		System.out.println("Starting Server");
		final HelloWorldImpl implementor = new HelloWorldImpl();
		final String address = "http://localhost:9000/helloWorld";
		Endpoint.publish(address, implementor);
	}

	@Before
	public void lookupWebService() {
		final JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(HelloWorldImpl.class);
		factory.setAddress("http://localhost:9000/helloWorld");
		client = (HelloWorldImpl) factory.create();
	}

	@Test
	public void testSayHiName() {
		final String reply = client.sayHi("Teste");
		System.out.println("Server said: " + reply);

		assertNotNull(reply);
	}

	@Test
	public void testSayHiUser() {
		final String reply = client.sayHiToUser(new User("Dênis",
				"Rua Odete, 114"));
		System.out.println("Server said: " + reply);

		assertNotNull(reply);
	}
}
