package com.eatpizza.carrito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;
import com.eatpizza.util.Accion;

public class EditDeletePizza extends Accion{

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción actualizar o borrar pizza.
	 * Devuelve un String con la vista a montar por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		PizzaVO pizza;
		ServicePizzas sp = new ServicePizzasImp();
		int id = Integer.parseInt(request.getParameter("pizza-list"));
		Double precio = Double.valueOf(request.getParameter("edit-precio"));
		System.out.println(id+precio);
		pizza = new PizzaVO(id, precio);
		
		if(request.getParameter("editPizza") != null) {
			sp.updatePizza(pizza);
		}
		if(request.getParameter("deletePizza") != null) {
			sp.deletePizza(pizza);
		}
		return "/admin.jsp";
	}

}
