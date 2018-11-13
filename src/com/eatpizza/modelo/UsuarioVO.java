package com.eatpizza.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "id")
	private int id;
	
	@Column (name = "email")
	private String email;
	
	@Column (name="password")
	private String password;
	
	@Column (name = "direccion")
	private String direccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roles_id")
	private RolVO rol;
	
	public UsuarioVO() {
	}
	
	public UsuarioVO(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public UsuarioVO(String email, String password, String direccion) {
		this.email = email;
		this.password = password;
		this.direccion = direccion;
	}
	
	public UsuarioVO(int id, String email, String password, String direccion) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int idUsuarios) {
		this.id = idUsuarios;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public RolVO getRol() {
		return rol;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}
	
}
