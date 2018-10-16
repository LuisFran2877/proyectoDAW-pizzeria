package com.eatpizza.dao;

import java.util.List;

import com.eatpizza.modelo.PizzaVO;

public interface PizzasDAO {
	
	public List<PizzaVO> getPizzasWithIngrediente(String nombreIngrediente);
	public PizzaVO getPizza(String nombrePizza);
	public List<PizzaVO> getPizzas();

}
