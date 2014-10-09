package com.cloud.rent.model.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cloud.rent.util.TransactionComparator;

@Entity(name = "TRANSACTION")
public class Transaction implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4441495441124267464L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "URL")
	private String url;
	@ManyToOne
	@JoinColumn(name = "PARENT")
	private Transaction parent;
	@OneToMany(mappedBy = "parent")
	private Set<Transaction> children = new TreeSet<Transaction>(new TransactionComparator());
	@ManyToMany
	@JoinTable(name = "ROLES_TRANSACTION", joinColumns = { @JoinColumn(name = "TRANSACTIONID") }, inverseJoinColumns = { @JoinColumn(name = "ROLID") })
	private Set<Rol> roles = new HashSet<Rol>(0);
	@Column(name="LEVEL")
	private Integer level;
	@Column(name="TRANSACTIONTYPE")
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	public enum TransactionType{
		ROOT,
		FOLDER,
		NODE
	}

	public Transaction() {
		super();
	}

	public Transaction(String name, String url, Transaction parent,
			Set<Transaction> children, String type, Set<Rol> roles, TransactionType transactionType) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
		this.children = children;
		this.transactionType = transactionType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Transaction getParent() {
		return parent;
	}

	public void setParent(Transaction parent) {
		this.parent = parent;
	}

	public Set<Transaction> getChildren() {
		return children;
	}

	public void setChildren(Set<Transaction> children) {
		this.children = children;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Transaction other = (Transaction) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
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
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Transaction [id=").append(id)
				.append(", name=").append(name).append(", url=").append(url)
				.append(", parent=").append(parent).append("]").toString();
	}

}
