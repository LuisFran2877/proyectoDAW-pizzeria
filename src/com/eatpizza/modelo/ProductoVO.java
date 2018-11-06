package com.eatpizza.modelo;

import java.io.Serializable;

public class ProductoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private PizzaVO producto;
	private int cantidad;
	
	public ProductoVO() {
		
	}
	
	public ProductoVO(PizzaVO producto) {
		this.producto = producto;
	}
	
	public ProductoVO(PizzaVO producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public PizzaVO getProducto() {
		return producto;
	}

	public void setProducto(PizzaVO producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
