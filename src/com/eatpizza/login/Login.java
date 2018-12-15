package com.eatpizza.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.modelo.UsuarioVO;
import com.eatpizza.service.ServiceUsuarios;
import com.eatpizza.service.ServiceUsuariosImp;
import com.eatpizza.util.Accion;

public class Login extends Accion {

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción login.
	 * Devuelve un String con la vista/s a montar por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		ServiceUsuarios su = new ServiceUsuariosImp();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UsuarioVO usuario = su.login(email, password);
		if(usuario != null) {
			session.setAttribute("usuario", usuario);
		}
		else {
			session.setAttribute("loginError", "Usuario o contraseña erróneos.");
			return "/login.jsp";
		}
		
		return "/index.jsp";
	}

}
