package com.training.spring.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserObject {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String surname;

	@Size(min = 6, max = 20)
	@NotNull
	@Column(unique = true, nullable = false, length = 20)
	private String username;

	@Column(nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private List<RoleObject> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public List<RoleObject> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleObject> roles) {
		this.roles = roles;
	}

	public List<String> rolesArray() {
		List<String> roleList = new ArrayList<String>();
		if (roles != null) {
			for (RoleObject role : roles) {
				roleList.add(role.getRoleName());
			}
		}

		return roleList;
	}

}
