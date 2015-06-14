package it.uniroma3.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.MERGE;

@Entity
@NamedQueries({
@NamedQuery(name="getCustomerByEmail", query = "SELECT x FROM Customer x WHERE x.email = :emailX")
})

public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column (nullable=false)
	private String firstname;
	@Column (nullable=false)
	private String lastname;
	
	@Column(nullable=false,unique=true)
	private String email;
	private String password;
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = { PERSIST, REMOVE, MERGE })
	private Address address;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = { REMOVE, MERGE })
	@JoinColumn(name="customer_id")
	private List<Order> orders; 
	
	public Customer(){}
	
	public Customer(String fname,String lname,String email,String pwd,String phoneNumber,Address address){
		this.lastname=lname;
		this.firstname=fname;
		this.email=email;
		this.password=pwd;
		this.phoneNumber=phoneNumber;
		this.address=address;
		this.registrationDate = new Date();
		this.orders=new LinkedList<Order>();
		
	}
	
	public Long getId(){
		return this.id;
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public String getLastname(){
		return this.lastname;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}

	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}

	public Date getRegistrationDate(){
		return this.registrationDate;
	}

	public Address getAddress(){
		return this.address;
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}
	
	public void setOrders(List<Order> orders){
		this.orders=orders;
	}

	public void setFirstname(String s){
		this.firstname=s;
	}
	
	public void setLastname(String s){
		this.lastname=s;
	}
	
	public void setEmail(String s){
		this.email=s;
	}
	
	public void setPassword(String pwd){
		this.password=pwd;
	}
	
	public void setPhoneNumber(String s){
		this.phoneNumber=s;
	}
	
	public void setDateOfBirth(Date date){
		this.dateOfBirth=date;
	}
	
	public void setRegistrationDate(Date date){
		this.registrationDate=date;
	}

	public void setAddress(Address a){
		this.address=a;
	}
}   
