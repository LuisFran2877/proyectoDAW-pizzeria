package com.eatpizza.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eatpizza.carrito.AddProducto;
import com.eatpizza.carrito.RemoveProducto;
import com.eatpizza.login.AddUser;
import com.eatpizza.login.Login;
import com.eatpizza.login.Logout;
import com.eatpizza.modelo.ProductoVO;


public abstract class Accion {
	
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static Accion getAccion(String tipo) {
		Accion accion = null;
		if (tipo.equals("addToCart")) {
			accion = new AddProducto();
		}
		if (tipo.equals("removeFromCart")) {
			accion = new RemoveProducto();
		}
		if (tipo.equals("login")) {
			accion = new Login();
		}
		if (tipo.equals("logout")) {
			accion = new Logout();
		}
		if (tipo.equals("addUser")) {
			accion = new AddUser();
		}
		return accion;
	}
	
	public static int existe(ProductoVO producto, List<ProductoVO> productos) {
		
		for(int i=0; i < productos.size(); i++) {
			if(productos.get(i).getProducto().getId() == producto.getProducto().getId()) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static double totalPrecio(List<ProductoVO> productos) {
		
		double total = 0;
		
		for(ProductoVO producto : productos) {
			total += producto.getCantidad() * producto.getProducto().getPrecio();
		}
		
		return total;
		
	}
	
	public static int totalProductos(List<ProductoVO> productos) {
		
		int total = 0;
		
		for(ProductoVO producto : productos) {
			total += producto.getCantidad();
		}
		
		return total;
	}

}