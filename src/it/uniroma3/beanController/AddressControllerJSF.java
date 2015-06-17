package it.uniroma3.beanController;
//prova Git6
import it.uniroma3.model.Address;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
	
public class AddressControllerJSF{
		private String city;
		private String street;
		private String state;
		private String country;
		private String zipcode;
		private Address address;
		private int streetNumber;

		public String createAddress(){
			this.address=new Address(city,street,state,zipcode,country,streetNumber);
			return "confermeDataCustomer";
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
		
		public Address getAddress(){
			return this.address;
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
		
		public void setAddress(Address address){
			this.address=address;
		}
	}