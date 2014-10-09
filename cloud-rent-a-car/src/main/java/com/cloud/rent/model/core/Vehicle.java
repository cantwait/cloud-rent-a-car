package com.cloud.rent.model.core;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="VEHICLE")
public class Vehicle implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5981899463813985146L;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	@Column(name="BRAND")
	private String brand;
	@Column(name="PLATE")
	private String plate;
	@ManyToOne
	@JoinColumn(name="COMPANYID")
	private Company company;
	@Column(name="AVAILABLE")
	private Boolean available;
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinTable(name="VEHICLE_ACCESSORY", joinColumns={@JoinColumn(name="VEHICLEID")}, inverseJoinColumns={@JoinColumn(name="ACCESSORYID")})
	private Set<Accessory> vehicles = new HashSet<Accessory>(0);
	@OneToMany(mappedBy="vehicle",fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=false)
	private Set<Manteinance> manteinances = new HashSet<Manteinance>(0);
	@OneToMany(mappedBy="vehicle", cascade=CascadeType.ALL, orphanRemoval=false)
	private Set<Rent> rents = new HashSet<Rent>(0);
	@OneToMany(mappedBy="vehicle",fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<URLResource> photos = new HashSet<URLResource>(0);
	
	public Vehicle(){}

	public Vehicle(String brand, String plate, Company company,
			Boolean available) {
		super();
		this.brand = brand;
		this.plate = plate;
		this.company = company;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((available == null) ? 0 : available.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (available == null) {
			if (other.available != null)
				return false;
		} else if (!available.equals(other.available))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
	
	
	

}
