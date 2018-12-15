package com.eatpizza.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.modelo.RolVO;
import com.eatpizza.modelo.UsuarioVO;
import com.eatpizza.service.ServiceUsuarios;
import com.eatpizza.service.ServiceUsuariosImp;
import com.eatpizza.util.Accion;

public class AddUser extends Accion{

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción aañadir usuario.
	 * Devuelve un String con la vista/s a montar por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String direccion = request.getParameter("direccion");
		UsuarioVO usuario = new UsuarioVO(email, password, direccion);
		usuario.setRol(new RolVO(2));
		
		ServiceUsuarios su = new ServiceUsuariosImp();
		boolean seRegistra = su.registrarUsuario(usuario);
		if(seRegistra) {
			return "/login.jsp";
		}
		else {
			session.setAttribute("registerError", "El usuario ya existe");
			return "/registro.jsp";
		}
		
	}

}
