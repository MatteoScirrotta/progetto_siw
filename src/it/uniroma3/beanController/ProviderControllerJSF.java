package it.uniroma3.beanController;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.uniroma3.model.Address;
import it.uniroma3.model.Provider;
import it.uniroma3.model.ProviderFacade;


@ManagedBean
@SessionScoped

public class ProviderControllerJSF {


	private Long id;

	private String name;
	private Address address;
	private String partitaIva;
	private Provider provider;
	private List<Provider> providers;

	//variabili per l' address
	private String city;
	private String street;
	private String state;
	private String country;
	private String zipcode;
	private int streetNumber;
	private String addressToString;

	@EJB(beanName="prFacade")
	private ProviderFacade providerFacade;


	public String createProvider(){
		this.provider = providerFacade.createProvider(name, address, partitaIva);
		return "adminHome";
	}

	public String newProvider(){
		return "newProvider";
	}

	public String newAddress(){
		return "newAddressProvider";
	}



	public String createAddress(){
		this.address=new Address(city,street,state,zipcode,country,streetNumber);
		return "confermeDataProvider";
	}

	public String getAllProviders(){
		this.providers=providerFacade.getAllProviders();
		return "providers";
	}

	public String addProduct(){
		this.providers=providerFacade.getAllProviders();
		return "chooseProvider";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getAddressToString() {
		return addressToString;
	}

	public void setAddressToString(String addressToString) {
		this.addressToString = addressToString;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

}
