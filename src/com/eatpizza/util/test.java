package com.eatpizza.util;

import java.util.List;

import com.eatpizza.daoImp.IngredientesDAOImp;
import com.eatpizza.daoImp.PizzasDAOImp;
import com.eatpizza.modelo.IngredienteVO;
import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MySqlDAOFactory df = new MySqlDAOFactory();
		
		/*IngredientesDAOImp i = (IngredientesDAOImp) df.getIngredientesDAO();
		List<IngredienteVO> ingredientes = i.getIngredientesfromPizza("Pizza Astur");
		for(IngredienteVO ingrediente : ingredientes) {
			System.out.print(ingrediente + ", ");
		}*/
		
		System.out.println();
		
		PizzasDAOImp p = (PizzasDAOImp) df.getPizzasDAO();
		//List<PizzaVO> pizzas = p.getPizzasWithIngrediente("Salsa de tomate");
		//for(PizzaVO pizza : pizzas) {
			//System.out.print(pizza + ", ");
		//}
		//PizzaVO pizza = p.getPizza("pizza barbacoa");
		//System.out.println(pizza.getNombre() +": "+ pizza.getIngredientes());
		
		List<PizzaVO> pizzas;
		ServicePizzas sp = new ServicePizzasImp();
		pizzas = sp.getPizzas();
		for(PizzaVO pizza : pizzas) {
			System.out.println(pizza.getNombre());
		}

	}

}
