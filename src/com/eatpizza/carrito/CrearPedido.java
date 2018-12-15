package com.eatpizza.carrito;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.modelo.PaqueteVO;
import com.eatpizza.modelo.ProductoVO;
import com.eatpizza.modelo.UsuarioVO;
import com.eatpizza.service.ServicePedidos;
import com.eatpizza.service.ServicePedidosImp;
import com.eatpizza.util.Accion;

public class CrearPedido extends Accion {

	@Override
	/**
	 * Sobreescribe el método ejecutar de la clase Accion para ejecutar
	 * la acción crear pedido.
	 * Devuelve un String con la vista a montar por PizzeriaController
	 */
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String email, direccion;
		UsuarioVO usuario;
		PaqueteVO paquete;
		List<PaqueteVO> paquetes = new ArrayList<PaqueteVO>();
		List<ProductoVO> productos;
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("usuario") != null) {
			usuario = (UsuarioVO) session.getAttribute("usuario");
			email = usuario.getEmail();
			direccion = usuario.getDireccion();
		}
		else {
			email = request.getParameter("email");
			direccion = request.getParameter("direccion");
		}
		
		productos = (List<ProductoVO>) session.getAttribute("productos");
		for(ProductoVO producto : productos) {
			paquete = new PaqueteVO(producto.getProducto().getNombre(), producto.getCantidad(), 
					producto.getCantidad() * producto.getProducto().getPrecio(), 
					email, direccion);
			paquetes.add(paquete);
		}
		
		ServicePedidos sp = new ServicePedidosImp();
		sp.addPedido(paquetes);
		
		session.removeAttribute("productos");
		session.removeAttribute("carrito");
		
		return "/index.jsp";
	}

}
