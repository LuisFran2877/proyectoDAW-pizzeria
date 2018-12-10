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
@Table(name = "ingredientes")
public class IngredienteVO implements Serializable {
	
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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        })
	@JoinTable(
			name="recetas", 
			joinColumns={@JoinColumn(name="ingredientes_id")}, 
			inverseJoinColumns={@JoinColumn(name="pizzas_id")},
			foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
			inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
	)
	private Set<PizzaVO> pizzas = new HashSet<PizzaVO>();
	
	public IngredienteVO() {	
	}
	
	public IngredienteVO(int id) {
		this.id = id;
	}
	
	public IngredienteVO(String nombre) {
		this.nombre = nombre;
	}
	
	public IngredienteVO(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	public Set<PizzaVO> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<PizzaVO> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		return nombre;
	}
	

}
