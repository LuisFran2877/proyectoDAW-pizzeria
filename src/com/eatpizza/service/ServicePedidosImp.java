package com.eatpizza.service;

import java.util.List;

import com.eatpizza.dao.PedidosDAO;
import com.eatpizza.modelo.PaqueteVO;
import com.eatpizza.util.MySqlDAOFactory;

public class ServicePedidosImp implements ServicePedidos {
	
	MySqlDAOFactory factoria;
	PedidosDAO p;
	
	public ServicePedidosImp() {
		factoria = new MySqlDAOFactory();
		p = factoria.getPedidosDAO();
	}

	@Override
	public void addPedido(List<PaqueteVO> paquetes) {
		// TODO Auto-generated method stub
		
		p.addPedido(paquetes);
		
	}
	
}
