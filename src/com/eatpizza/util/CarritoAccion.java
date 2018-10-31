package com.eatpizza.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eatpizza.modelo.ProductoVO;

import carrito.AddProducto;
import carrito.RemoveProducto;


public abstract class CarritoAccion {
	
	public List<ProductoVO> productos;
	
	public CarritoAccion() {
		this.productos = new ArrayList<ProductoVO>();
	}
	
	public abstract void ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static CarritoAccion getAccion(String tipo) {
		CarritoAccion accion = null;
		if (tipo.equals("addToCart")) {
			accion = new AddProducto();
		}
		if (tipo.equals("removeFromCart")) {
			accion = new RemoveProducto();
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
			total += producto.getCandidad() * producto.getProducto().getPrecio();
		}
		
		return total;
		
	}
	
	public static int totalProductos(List<ProductoVO> productos) {
		
		int total = 0;
		
		for(ProductoVO producto : productos) {
			total += producto.getCandidad();
		}
		
		return total;
	}

}
