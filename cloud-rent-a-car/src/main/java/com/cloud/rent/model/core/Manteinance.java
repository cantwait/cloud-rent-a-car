package com.cloud.rent.model.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="MANTEINANCE")
public class Manteinance implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4018198534285148265L;
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	@Column(name="DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(name="VEHICLEID")
	private Vehicle vehicle;
	@Column(name="STARTEDAT")
	private Date startedAt;
	@Column(name="ENDEDAT")
	private Date endedAt;
	@Column(name="DURATION")
	private Integer duration;
	
	public Manteinance(){}

	public Manteinance(String description, Vehicle vehicle,
			Date startedAt, Date endedAt) {
		super();
		this.description = description;
		this.vehicle = vehicle;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endedAt == null) ? 0 : endedAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((startedAt == null) ? 0 : startedAt.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		Manteinance other = (Manteinance) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endedAt == null) {
			if (other.endedAt != null)
				return false;
		} else if (!endedAt.equals(other.endedAt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startedAt == null) {
			if (other.startedAt != null)
				return false;
		} else if (!startedAt.equals(other.startedAt))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}
	
	
	

}
