package com.DeadPoets.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "writer")
public class Writer {
	
	public Writer(){
		
	}
	
    public Writer(String username, String firstname, String lastname, String email, String password){
		
    	this.username = username;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.email = email;
    	this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "writer_id")
	private Long writer_id;
	
	@NotNull
	@Size(min=3, max=20, message= "Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$",message="Username must be alphanumeric with no spaces")
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
	@Column(name = "firstname")
	private String firstname;
	
	
	@NotNull
	@Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "writer")
	private List<Post> posts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "writers")
	private List<Role> roles;
	
	@NotEmpty
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="Invalid email address.")
	@Column(name = "email")
	private String email;
	
	@Column(name = "enable")
	private boolean enable;
	
	@Column(name = "avatar")
	private String avatar;
	
	public Long getId() {
		return writer_id;
	}
	public void setId(Long id) {
		this.writer_id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Post> getPosts() {
		return posts;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(Long writer_id) {
		this.writer_id = writer_id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
		
}
