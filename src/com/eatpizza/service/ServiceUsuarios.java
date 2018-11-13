package com.eatpizza.service;

import com.eatpizza.modelo.UsuarioVO;

public interface ServiceUsuarios {
	
	public UsuarioVO login(String email, String password);
	public boolean registrarUsuario(UsuarioVO usuario);

}
