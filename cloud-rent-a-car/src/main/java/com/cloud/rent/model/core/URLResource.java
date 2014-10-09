package com.cloud.rent.model.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="URLRESOURCE")
public class URLResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6352033309667037086L;
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(name="VEHICLEID")
	private Vehicle vehicle;
	
	public URLResource(){}
	
	
	public URLResource(String description, BinaryFile binaryResource){
		this.description = description;
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




	@Override
	public String toString() {
		return "URLResource [id=" + id + ", description=" + description + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		URLResource other = (URLResource) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
