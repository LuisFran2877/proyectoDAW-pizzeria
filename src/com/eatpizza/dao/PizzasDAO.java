package com.eatpizza.dao;

import java.util.List;

import com.eatpizza.modelo.PizzaVO;

public interface PizzasDAO {
	
	public List<PizzaVO> getPizzasWithIngrediente(String nombreIngrediente);
	public PizzaVO getPizza(String nombrePizza);
	public List<PizzaVO> getPizzas();
	public void addPizza(PizzaVO pizza);
	public void updatePizza(PizzaVO pizza);
	public void deletePizza(PizzaVO pizza);
	public double getPrecio(String nombrePizza);

}
