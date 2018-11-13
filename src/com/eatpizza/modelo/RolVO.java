package com.eatpizza.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RolVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "rol")
	private String rol;
	
	@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
	private Set<UsuarioVO> usuarios = new HashSet<UsuarioVO>();

	public RolVO() {
		
	}
	
	public RolVO(String rol) {
		this.rol = rol;
	}
	
	public RolVO(int id) {
		this.id = id;
	}
	
	public RolVO(int id, String rol) {
		this.id = id;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Set<UsuarioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioVO> usuarios) {
		this.usuarios = usuarios;
	}

}
