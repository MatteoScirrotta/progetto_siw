package it.uniroma3.beanController;

import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Order;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




@ManagedBean
@SessionScoped

public class CustomerController {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phoneNumber;
	private Date dateOfBirth;
	private int day;
	private int month;
	private int year;
	private Address address;
	private Date registrationDate;
	private List<Order> orders;
	private Customer customer;
	private boolean log;

	//variabili per l' address
	private String city;
	private String street;
	private String state;
	private String country;
	private String zipcode;
	private int streetNumber;
	private String addressToString;
	@EJB(beanName="cFacade")
	private CustomerFacade customerFacade;
	
	public CustomerController(){}
	
	@SuppressWarnings("deprecation")
	public String createCustomer(){
		this.dateOfBirth = new Date(this.year-1900, this.month-1, this.day);
		this.customer=customerFacade.createCustomer(firstname,lastname,email,password,phoneNumber,address,dateOfBirth);
		log=true;
		return "homeCustomer";
	}
	
	public String createAddress(){
		this.address=new Address(city,street,state,zipcode,country,streetNumber);
		return "confermeDataCustomer";
	}
	
	public String checkLogin(){
		this.customer=customerFacade.checkLogin(email, password);
		if(customer == null)
			return "login";
		this.orders=customer.getOrders();
		log=true;
		return "homeCustomer";
	}
	
	public String goForward(){
		return "newAddress";
	}
	
	public String goBack(){
		return"homeCustomer";
	}
	
	public void updateCustomer(Customer customer){
		customerFacade.updateCustomer(customer);
	}
	
	public String logout(){
		log=false;
		email="";
		password="";
		return "index";
	}
	
	public String findCustomer(Customer customer){
		this.customer=customer;
		addressToString=this.customer.getAddress().toString();
		return"adminCustomer";
	}
	
	public boolean getLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public String getLastname(){
		return this.lastname;
	}
	
	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public Date getRegistrationDate(){
		return this.registrationDate;
	}
	
	public Address getAddress(){
		return this.address;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public String getAddressToString() {
		return addressToString;
	}

	public void setAddressToString(String addressToString) {
		this.addressToString = addressToString;
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}
	
	public void setOrders(List<Order> orders){
		this.orders=orders;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	
	public int getStreetNumber(){
		return this.streetNumber;
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
	
	public String getCountry(){
		return this.country;
	}
	
	public String getZipcode(){
		return this.zipcode;
	}
	
	public void setStreetNumber(int streetNumber){
		this.streetNumber=streetNumber;
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
	
	public void setCountry(String country){
		this.country=country;
	}
	
	public void setZipcode(String zipcode){
		this.zipcode=zipcode;
	}
	
	public void setCustomer(Customer customer){
		this.customer=customer;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setId(Long id) {
		this.id = id;
	}
}



