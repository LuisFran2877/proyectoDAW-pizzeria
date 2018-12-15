package com.eatpizza.carrito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;
import com.eatpizza.util.Accion;

public class ObtenerPrecio extends Accion {

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción obtener precio de una pizza.
	 * Devuelve un String que será devuelto por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		String nombrePizza = request.getParameter("nombrePizza");
		ServicePizzas pi = new ServicePizzasImp();
		return String.valueOf(pi.getPrecio(nombrePizza));
		
		
	}

}
