package com.eatpizza.carrito;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eatpizza.modelo.IngredienteVO;
import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;
import com.eatpizza.util.Accion;

public class AddPizza extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
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
		sp.addPizza(pizza);
		
		return "/admin.jsp";
	}

}
