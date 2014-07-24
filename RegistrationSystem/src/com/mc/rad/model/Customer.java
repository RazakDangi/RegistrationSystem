package com.mc.rad.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="InformationPerson")
@Table(name = "Customer", catalog = "mcDB")
public class Customer {

	private Integer customerId;

	private String name;

	private String state;

	private String occupation;

	private String country;

	private String gender;

	private Date createdOn;

	public Customer() {
		super();
	}

	@XmlAttribute
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUST_ID", nullable = false, unique = true)
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@XmlElement
	@Column(name = "CUST_NAME", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	@Column(name = "STATE", nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@XmlElement
	@Column(name = "OCCUPATION", nullable = false)
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@XmlElement
	@Column(name = "COUNTRY", nullable = false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@XmlElement
	@Column(name = "GENDER", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@XmlElement
	@Column(name = "CreatedOn")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name
				+ ", state=" + state + ", occupation=" + occupation
				+ ", country=" + country + ", gender=" + gender
				+ ", createdOn=" + createdOn + "]";
	}
	
	
	

}
