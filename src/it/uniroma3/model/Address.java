package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column (nullable=false)
	private String city;
	@Column (nullable=false)
	private String street;
	@Column (nullable=false)
	private int streetNumber;
	@Column (nullable=false)
	private String state;
	@Column (nullable=false)
	private String zipcode;
	private String country;
	

	
	public Address(){}
	
	public Address(String city,String street,String state, String zipcode,String country,int streetNumber){
		this.city=city;
		this.street=street;
		this.state=state;
		this.zipcode=zipcode;
		this.country=country;
		this.streetNumber=streetNumber;
	}
	
	
	
	public Long getId(){
		return this.id;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public String getStreet(){
		return this.street;
	}

	public String getState(){
		return this.state;
	}

	public String getZipcode(){
		return this.zipcode;
	}

	public String getCountry(){
		return this.country;
	}
	
	public int getStreetNumber(){
		return this.streetNumber;
	}

	public void setCity(String city){
		this.city=city;
	}
	
	public void setStreet(String street){
		this.street=street;
	}
	
	public void setState(String state){
		this.state=state;
	}
	
	public void setZipcode(String zipcode){
		this.zipcode=zipcode;
	}
	
	public void setCountry(String country){
		this.country=country;
	}
	
	public void setStreetNumber(int streetNumber){
		this.streetNumber=streetNumber;
	}
	
	@Override
	public String toString() {
		return street + ", " + streetNumber
				+ ", " + zipcode + ", " + city + ", "
				+ state + ", " + country ;
	}
	
	
}  