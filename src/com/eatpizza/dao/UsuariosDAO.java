package com.eatpizza.dao;

import com.eatpizza.modelo.UsuarioVO;

public interface UsuariosDAO {
	
	public UsuarioVO getUsuario(String email, String password);
	public UsuarioVO getusuario(String email);
	public void addUsuario(UsuarioVO usuario);
	
}
