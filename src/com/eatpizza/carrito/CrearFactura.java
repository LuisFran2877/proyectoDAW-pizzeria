package com.eatpizza.carrito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.util.Accion;

public class CrearFactura extends Accion {

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción crear factura.
	 * Devuelve un String con la vista/s a montar por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("productos") == null) {
			return "/index.jsp";
		}
		return "/factura.jsp";
	}

}
