package com.eatpizza.service;

import java.util.List;

import com.eatpizza.modelo.PizzaVO;

public interface ServicePizzas {
	
	public List<PizzaVO> getPizzas();
	public void addPizza(PizzaVO pizza);
	public void updatePizza(PizzaVO pizza);
	public void deletePizza(PizzaVO pizza);
	public double getPrecio(String nombrePizza);

}
