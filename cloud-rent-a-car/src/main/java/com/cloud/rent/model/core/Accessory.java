package com.cloud.rent.model.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="ACCESSORY")
public class Accessory {
	
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="SERIAL")
	private String serial;
	@Column(name="MODEL")
	private String model;
	@ManyToMany(mappedBy="vehicles")
	private Set<Vehicle> accessories = new HashSet<Vehicle>(0);
	
	public Accessory(){}

	public Accessory(String name, String description, String serial,
			String model) {
		super();
		this.name = name;
		this.description = description;
		this.serial = serial;
		this.model = model;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	

}
