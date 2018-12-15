package com.eatpizza.carrito;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.modelo.IngredienteVO;
import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;
import com.eatpizza.util.Accion;

public class AddPizza extends Accion{

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción añadir pizza.
	 * Devuelve un String con la vista a montar por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		String nombre = request.getParameter("nombre");
		Double precio = Double.valueOf(request.getParameter("precio"));
		String[] ingredientes = request.getParameterValues("ingrediente");
		
		Set<IngredienteVO> listaIngredientes = new HashSet<IngredienteVO>();
		IngredienteVO ingrediente = null;
		for(int i=0; i<ingredientes.length; i++) {
			System.out.println(i);
			ingrediente = new IngredienteVO(Integer.parseInt(ingredientes[i]));
			listaIngredientes.add(ingrediente);
		}
		PizzaVO pizza = new PizzaVO(nombre, precio, listaIngredientes);
		
		ServicePizzas sp = new ServicePizzasImp();
		boolean nuevaPizza = sp.addPizza(pizza);
		if(nuevaPizza) {
			sp.addPizza(pizza);
		} else {
			session.setAttribute("addPizzaError", "No se puede añadir una pizza existente");
		}
		
		return "/admin.jsp";
	}

}
