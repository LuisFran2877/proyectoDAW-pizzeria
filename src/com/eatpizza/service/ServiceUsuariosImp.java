package com.eatpizza.service;

import com.eatpizza.dao.UsuariosDAO;
import com.eatpizza.modelo.UsuarioVO;
import com.eatpizza.util.MySqlDAOFactory;

public class ServiceUsuariosImp implements ServiceUsuarios {
	
	MySqlDAOFactory factoria;
	UsuariosDAO u;
	
	public ServiceUsuariosImp() {
		factoria = new MySqlDAOFactory();
		u = factoria.getUsuariosDAO();
	}

	@Override
	public UsuarioVO login(String email, String password) {
		return u.getUsuario(email, password);
	}

	@Override
	public boolean registrarUsuario(UsuarioVO usuario) {
		
		UsuarioVO usuarioRegistrado = u.getusuario(usuario.getEmail());
		if(usuarioRegistrado != null) {
			return false;
		}
		else {
			u.addUsuario(usuario);
		}
		
		return true;
		
	}

	@Override
	public UsuarioVO getusuario(String email) {
		return u.getusuario(email);
	}

}
