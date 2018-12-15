package com.eatpizza.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.util.Accion;

public class Logout extends Accion {

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción logout.
	 * Devuelve un String con la vista a montar por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("usuario") != null) {
			session.removeAttribute("usuario");
		}
		return "/index.jsp";
	}

}
