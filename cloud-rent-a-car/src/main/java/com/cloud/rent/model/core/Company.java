package com.cloud.rent.model.core;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cloud.rent.model.security.User;
import com.cloud.rent.util.CompanyComparator;

@Entity
public class Company implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6750811091150903995L;
	@Id 
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATIONDATE")
	private Date created;
	@ManyToOne
	@JoinColumn(name="BELONGSTO")
	private Company belongsTo;
	@OneToMany(mappedBy="belongsTo")
	private Set<Company> branches = new TreeSet<Company>(new CompanyComparator());
	@Column(name="IDLOGO")
	private Long idPhoto;
	@ManyToMany(cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinTable(name="USER_COMPANY", joinColumns={@JoinColumn(name="COMPANYID")}, inverseJoinColumns={@JoinColumn(name="USERID")})
	private Set<User> users = new HashSet<User>(0);
	@Column(name="LEVEL")
	private Integer level;
	@Enumerated(EnumType.STRING)
	@Column(name="COMPANYTYPE")
	private CompanyType companyType;
	
	public enum CompanyType {
		ROOT,
		MASTER,
		BRANCH
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Company getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(Company belongsTo) {
		this.belongsTo = belongsTo;
	}
	public Set<Company> getBranches() {
		return branches;
	}
	public void setBranches(Set<Company> branches) {
		this.branches = branches;
	}
	
	public Long getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(Long idPhoto) {
		this.idPhoto = idPhoto;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	public CompanyType getCompanyType() {
		return companyType;
	}
	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description="
				+ description + ", created=" + created + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Company other = (Company) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
