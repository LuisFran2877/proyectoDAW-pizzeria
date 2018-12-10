package com.eatpizza.daoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eatpizza.dao.PedidosDAO;
import com.eatpizza.modelo.PaqueteVO;

public class PedidosDAOImp implements PedidosDAO{
	
	SessionFactory sf;
	Session sesion;
	
	public PedidosDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void addPedido(List<PaqueteVO> paquetes) {
		// TODO Auto-generated method stub
		
		try {
			sesion = sf.openSession();
			sesion.beginTransaction();
			for(PaqueteVO paquete : paquetes) {
				sesion.persist(paquete);
			}
			sesion.getTransaction().commit();
			sesion.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		
	}

}
