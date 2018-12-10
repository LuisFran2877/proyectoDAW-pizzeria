package com.eatpizza.daoImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eatpizza.dao.UsuariosDAO;
import com.eatpizza.modelo.UsuarioVO;

public class UsuariosDAOImp implements UsuariosDAO {
	
	SessionFactory sf;
	Session sesion;
	
	public UsuariosDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public UsuarioVO getUsuario(String email, String password) {
		
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			Query q = sesion.createQuery("select u from UsuarioVO u where u.email=:email and u.password=:password");
			q.setParameter("email", email);
			q.setParameter("password", password);
			usuarios = q.getResultList();
			for(UsuarioVO usuario : usuarios) {
				Hibernate.initialize(usuario.getRol());
			}
			sesion.getTransaction().commit();
			sesion.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		
		if(usuarios.size() > 0) {
			return usuarios.get(0);
		}

		return null;
	}
	
	@Override
	public UsuarioVO getusuario(String email) {
		
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			Query q = sesion.createQuery("select u from UsuarioVO u where u.email=:email");
			q.setParameter("email", email);
			usuarios = q.getResultList();
			for(UsuarioVO usuario : usuarios) {
				Hibernate.initialize(usuario.getRol());
			}
			sesion.getTransaction().commit();
			sesion.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		
		if(usuarios.size() > 0) {
			return usuarios.get(0);
		}

		return null;
		
	}

	@Override
	public void addUsuario(UsuarioVO usuario) {
		
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			sesion.save(usuario);
			sesion.getTransaction().commit();
			sesion.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		
	}

}
