package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.UsuarioService;

public class ListarPaisBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		UsuarioService usuario = new UsuarioService();
		ArrayList<Pais> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = usuario.listarPaises(chave);
		} else {
			lista = usuario.listarPaises();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarPaises.jsp");
		dispatcher.forward(request, response);
	}
}
