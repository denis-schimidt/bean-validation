package br.com.schimidtsolutions.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.schimidtsolutions.dto.Usuario;
import br.com.schimidtsolutions.ejb.HelloWorldFacadeServiceBean;

@WebServlet("/hello")
public class MeuSevlet extends HttpServlet {
	private static final long serialVersionUID = -7990872662257268646L;

	@Inject
	private HelloWorldFacadeServiceBean ejb;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final Usuario usuario = new Usuario(req.getParameter("nome"),
				Double.valueOf(req.getParameter("idade")));

		final PrintWriter writer = resp.getWriter();
		writer.printf("Testando meu ejb %s", ejb.getHelloWorld(usuario));

		writer.flush();
		writer.close();
	}
}
