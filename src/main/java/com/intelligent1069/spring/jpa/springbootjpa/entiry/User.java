package com.intelligent1069.spring.jpa.springbootjpa.entiry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonFilter("Filter_1")
@ApiModel(description="This entity defines user schema")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2)
	@ApiModelProperty(notes="Name takes minumum 2 chars")
	private String name;
	
	@Size(min=3)
	@ApiModelProperty(notes="Role takes minumum 2 chars")
	private String role;
	
	protected User()
	{
		
	}
	
	public User( String name, String role) {
		super();
	    this.name = name;
		this.role = role;
	}
	
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

	
	

}
