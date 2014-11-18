package com.DeadPoets.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "writerrole")
public class Role {
	
	public Role(){
		
	}
	
	public Role(String role, Writer writers){
		this.role = role;
		this.writers = writers;
		
	}
    
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long role_id;
	
	@Column(name = "role")
	private String role;
	
	@ManyToOne
	@JoinColumn(name  = "writer_id")
	private Writer writers;

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Writer getWriter() {
		return writers;
	}

	public void setWriter(Writer writers) {
		this.writers = writers;
	}
	
	
}
