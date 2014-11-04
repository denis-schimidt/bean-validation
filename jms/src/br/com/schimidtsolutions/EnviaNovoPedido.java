package br.com.schimidtsolutions;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviaNovoPedido {

	public static void main(String[] args) throws NamingException, JMSException {
		final Properties props = new Properties();
		props.setProperty("java.naming.factory.initial",
				"org.jboss.naming.remote.client.InitialContextFactory");
		props.setProperty("java.naming.provider.url", "remote://localhost:4447");
		props.setProperty("java.naming.security.principal", "k19");
		props.setProperty("java.naming.security.credentials", "1234");

		final InitialContext ic = new InitialContext(props);

		final ConnectionFactory factory = (ConnectionFactory) ic
				.lookup("jms/K19Factory");
		final Queue queue = (Queue) ic.lookup("jms/queue/pedidos");

		final Connection connection = factory.createConnection("k19", "1234");
		final Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		final MessageProducer sender = session.createProducer(queue);

		final TextMessage message = session.createTextMessage();
		message.setText("Uma pizza de cinco queijos e uma coca-cola 2l - "
				+ System.currentTimeMillis());

		sender.send(message);
		sender.close();
		session.close();
		connection.close();

		System.out.println("Mensagem Enviada");
		System.exit(0);
	}
}
