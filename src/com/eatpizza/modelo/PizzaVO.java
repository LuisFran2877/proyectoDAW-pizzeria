package com.eatpizza.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        })
	@JoinTable(
			name="recetas", 
			joinColumns={@JoinColumn(name="pizzas_id")}, 
			inverseJoinColumns={@JoinColumn(name="ingredientes_id")},
			foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
			inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
	)
	private Set<IngredienteVO> ingredientes = new HashSet<IngredienteVO>();
	
	public PizzaVO() {
	}
	
	public PizzaVO(int id) {
		this.id = id;
	}
	
	public PizzaVO(int id, double precio) {
		this.id = id;
		this.precio = precio;
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
	
	public PizzaVO(String nombre, double precio, Set<IngredienteVO> ingredientes) {
		this.nombre = nombre;
		this.precio = precio;
		this.ingredientes = ingredientes;
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
