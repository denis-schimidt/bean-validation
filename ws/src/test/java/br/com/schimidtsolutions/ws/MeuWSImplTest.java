package br.com.schimidtsolutions.ws;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.schimidtsolutions.ws.client.MeuWS;
import br.com.schimidtsolutions.ws.client.MeuWSService;

public class MeuWSImplTest {

	@Test
	public void testGetHelloWSWorld() {
		final MeuWS meuWSPort = new MeuWSService().getMeuWSPort();

		assertThat(meuWSPort.getHelloWorld(), equalTo("Hello World"));
	}
}
