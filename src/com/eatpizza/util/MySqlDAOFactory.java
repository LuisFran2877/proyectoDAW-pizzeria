package com.eatpizza.util;

import org.hibernate.SessionFactory;

import com.eatpizza.dao.IngredientesDAO;
import com.eatpizza.dao.PizzasDAO;
import com.eatpizza.dao.UsuariosDAO;
import com.eatpizza.daoImp.IngredientesDAOImp;
import com.eatpizza.daoImp.PizzasDAOImp;
import com.eatpizza.daoImp.UsuariosDAOImp;

public class MySqlDAOFactory {
	
private SessionFactory sf;
	
	/**
	 * Instancia una factoria para MySQL de DAOS.
	 * Recibe la conexión de HibernateUtility.
	 */
	public MySqlDAOFactory() {
		try {
			sf = HibernateUtility.getSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * Obtiene IngredientesDAO
	 * @return IngredientesDAO implementado con una Session Factory
	 */
	public IngredientesDAO getIngredientesDAO() {
		return new IngredientesDAOImp(sf);
	}
	
	public PizzasDAO getPizzasDAO() {
		return new PizzasDAOImp(sf);
	}
	
	public UsuariosDAO getUsuariosDAO() {
		return new UsuariosDAOImp(sf);
	}

}
