package com.eatpizza.service;

import java.util.List;

import com.eatpizza.dao.PizzasDAO;
import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.util.MySqlDAOFactory;

public class ServicePizzasImp implements ServicePizzas{
	
	MySqlDAOFactory factoria;
	PizzasDAO p;
	
	public ServicePizzasImp() {
		factoria = new MySqlDAOFactory();
		p = factoria.getPizzasDAO();
	}

	@Override
	public List<PizzaVO> getPizzas() {
		return p.getPizzas();
	}

	@Override
	public boolean addPizza(PizzaVO pizza) {
		
		PizzaVO existePizza = p.getPizza(pizza.getNombre());
		if(existePizza != null) {
			return false;
		} else {
			p.addPizza(pizza);
		}
		return true;
		
	}

	@Override
	public void updatePizza(PizzaVO pizza) {
		p.updatePizza(pizza);
	}

	@Override
	public void deletePizza(PizzaVO pizza) {
		p.deletePizza(pizza);
	}

	@Override
	public double getPrecio(String nombrePizza) {
		return p.getPrecio(nombrePizza);
	}

}
