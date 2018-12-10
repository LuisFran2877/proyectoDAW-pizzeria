package com.eatpizza.service;

import java.util.List;

import com.eatpizza.dao.IngredientesDAO;
import com.eatpizza.modelo.IngredienteVO;
import com.eatpizza.util.MySqlDAOFactory;

public class ServiceIngredientesImp implements ServiceIngredientes{
	
	MySqlDAOFactory factoria;
	IngredientesDAO i;
	
	public ServiceIngredientesImp() {
		factoria = new MySqlDAOFactory();
		i = factoria.getIngredientesDAO();
	}

	@Override
	public List<IngredienteVO> getIngredientes() {
		return i.getIngredientes();
	}

}
