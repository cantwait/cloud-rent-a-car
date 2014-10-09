package com.cloud.rent.model.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="BINARYFILE")
public class BinaryFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7609272535637173361L;
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="CONTENT")
	@Lob
	private byte[] content;
	
	public BinaryFile(){}
	
	public BinaryFile(byte[] content){
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
	
	

}
