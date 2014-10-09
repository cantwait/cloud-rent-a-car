package com.cloud.rent.model.core;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="DRIVER")
public class Driver implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1984509507268132962L;
	@Id
	@Column(name="ID")
	private String id;
	@Column(name="NAME")
	private String name;
	@Column(name="LICENSE")
	private String license;
	@Column(name="NATIONALITY")
	private String nationality;
	@OneToMany(mappedBy="driver",fetch=FetchType.LAZY, orphanRemoval=false,cascade=CascadeType.PERSIST)
	private Set<Rent> rents = new HashSet<Rent>(0);
	
	public Driver(){}
	
	public Driver(String id, String name, String license, String nationality){
		this.name = name;
		this.license = license;
		this.nationality = nationality;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", license=" + license
				+ ", nationality=" + nationality + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nationality == null) ? 0 : nationality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		return true;
	}
	
	

}
