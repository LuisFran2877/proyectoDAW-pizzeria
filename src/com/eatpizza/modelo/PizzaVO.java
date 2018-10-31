package com.eatpizza.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizzas")
public class PizzaVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "precio")
	private double precio;
	
	@ManyToMany(mappedBy = "pizzas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<IngredienteVO> ingredientes = new HashSet<IngredienteVO>();
	
	public PizzaVO() {
	}
	
	public PizzaVO(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public PizzaVO(int id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Set<IngredienteVO> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<IngredienteVO> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String toString() {
		return nombre;
	}

}
