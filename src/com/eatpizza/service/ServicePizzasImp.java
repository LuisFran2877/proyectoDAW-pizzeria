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

}
