package com.eatpizza.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eatpizza.dao.PizzasDAO;
import com.eatpizza.modelo.PizzaVO;

public class PizzasDAOImp implements PizzasDAO {
	
	SessionFactory sf;
	Session sesion;
	
	public PizzasDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<PizzaVO> getPizzasWithIngrediente(String nombre) {
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			Query q = sesion.createQuery("select p from PizzaVO p join p.ingredientes i where i.nombre=:nombre");
			q.setParameter("nombre", nombre);
			List<PizzaVO> pizzas = q.getResultList();
			sesion.getTransaction().commit();
			sesion.close();
			return pizzas;
		} catch (RuntimeException e){
			System.out.println("error al mostrar listado de pizzas "+e.getMessage());
			sesion.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public PizzaVO getPizza(String nombre) {
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			Query q = sesion.createQuery("from PizzaVO p where p.nombre=:nombre");
			q.setParameter("nombre", nombre);
			PizzaVO pizza = (PizzaVO) q.getSingleResult();
			Hibernate.initialize(pizza.getIngredientes());
			sesion.getTransaction().commit();
			sesion.close();
			return pizza;
		} catch (RuntimeException e){
			System.out.println("error al mostrar pizza "+e.getMessage());
			sesion.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<PizzaVO> getPizzas() {
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			Query q = sesion.createQuery("from PizzaVO p");
			List<PizzaVO> pizzas = q.getResultList();
			for(PizzaVO pizza : pizzas) {
				Hibernate.initialize(pizza.getIngredientes());
			}
			sesion.getTransaction().commit();
			sesion.close();
			return pizzas;
		} catch (RuntimeException e){
			System.out.println("error al mostrar listado de pizzas "+e.getMessage());
			sesion.getTransaction().rollback();
		}
		return null;
	}

}
