package com.eatpizza.carrito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;
import com.eatpizza.util.Accion;

public class ObtenerPrecio extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		String nombrePizza = request.getParameter("nombrePizza");
		ServicePizzas pi = new ServicePizzasImp();
		return String.valueOf(pi.getPrecio(nombrePizza));
		
		
	}

}
