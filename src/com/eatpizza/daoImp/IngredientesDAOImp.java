package com.eatpizza.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eatpizza.dao.IngredientesDAO;
import com.eatpizza.modelo.IngredienteVO;

public class IngredientesDAOImp implements IngredientesDAO {
	
	SessionFactory sf;
	Session sesion;
	
	public IngredientesDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<IngredienteVO> getIngredientesfromPizza(String nombre) {
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			Query q = sesion.createQuery("select i from IngredienteVO i join i.pizzas p where p.nombre=:nombre");
			q.setParameter("nombre", nombre);
			List<IngredienteVO> ingredientes = q.getResultList();
			sesion.getTransaction().commit();
			sesion.close();
			return ingredientes;
		} catch (RuntimeException e){
			System.out.println("error al mostrar usuario "+e.getMessage());
			sesion.getTransaction().rollback();
		}
		return null;
	}

	


}
