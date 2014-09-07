package com.cloud.rent.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Version implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2577551359071644560L;
	private String name = "Cloud Rental Car API";
	private String number = "1.0.0";
	private static Version v = null;
	
	public Version(){}
	
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public static Version getInstance(){
		if(v == null){
			v = new Version();
		}
		return v;
	}

}
