package com.eatpizza.dao;

import java.util.List;

import com.eatpizza.modelo.IngredienteVO;

public interface IngredientesDAO {
	
	public List<IngredienteVO> getIngredientesfromPizza(String nombre);
	public List<IngredienteVO> getIngredientes();

}
