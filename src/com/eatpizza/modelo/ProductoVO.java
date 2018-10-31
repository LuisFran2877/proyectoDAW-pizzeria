package com.eatpizza.modelo;

import java.io.Serializable;

public class ProductoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private PizzaVO producto;
	private int candidad;
	
	public ProductoVO() {
		
	}
	
	public ProductoVO(PizzaVO producto, int cantidad) {
		this.producto = producto;
		this.candidad = cantidad;
	}

	public PizzaVO getProducto() {
		return producto;
	}

	public void setProducto(PizzaVO producto) {
		this.producto = producto;
	}

	public int getCandidad() {
		return candidad;
	}

	public void setCandidad(int candidad) {
		this.candidad = candidad;
	}

}
