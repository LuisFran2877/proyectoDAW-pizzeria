package com.eatpizza.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuarios")
	private int idUsuarios;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "direccion")
	private String direccion;
	
	@Column (name = "roles")
	private char roles;
	
	public UsuarioVO() {
	}
	
	public UsuarioVO(String email, String direccion, char roles) {
		this.email = email;
		this.direccion = direccion;
		this.roles = roles;
	}
	
	public UsuarioVO(int idUsuarios, String email, String direccion, char roles) {
		this.idUsuarios = idUsuarios;
		this.email = email;
		this.direccion = direccion;
		this.roles = roles;
	}

	public int getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public char getRoles() {
		return roles;
	}

	public void setRoles(char roles) {
		this.roles = roles;
	}
	

}
