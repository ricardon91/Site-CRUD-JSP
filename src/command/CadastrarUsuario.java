package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Usuario;
import service.UsuarioService;

public class CadastrarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uId = request.getParameter("id");
		String nome = request.getParameter("username");
		String senha = request.getParameter("password");
		int id = -1;
		try {
			id = Integer.parseInt(uId);
		} catch (NumberFormatException e) {

		}

		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setUsername(nome);
		usuario.setPassword(senha);
		UsuarioService service = new UsuarioService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		service.criar(usuario);
		ArrayList<Usuario> lista = new ArrayList<>();
		lista.add(usuario);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("Cadastrar.jsp");

		view.forward(request, response);
	}
}
