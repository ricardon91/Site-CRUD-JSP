package service;

import java.util.ArrayList;

import dao.PaisDAO;
import dao.UsuarioDAO;
import model.Pais;
import model.Usuario;

public class UsuarioService {
	
	PaisDAO dao;
	UsuarioDAO daoUsu;
	
	public UsuarioService() {
		dao = new PaisDAO();
	}
	
	public ArrayList<Pais> listarPaises(){
		return dao.listarPaises();
	}
	
	public ArrayList<Pais> listarPaises(String chave){
		return dao.listarPaises(chave);
	}
	
	public int criar(Usuario usuario) {
		return daoUsu.criar(usuario);
	}
	
	public boolean validar(Usuario usuario){		
		return daoUsu.validar(usuario);
	}
}
