package it.uniroma3.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity

public class Provider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column (nullable=false)
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = { PERSIST, REMOVE, MERGE })
	@Column (nullable=false)
	private Address address;
	@Column (nullable=false)
	private String partitaIva;
	
	@ManyToMany(mappedBy="providers",fetch=FetchType.LAZY, cascade = { PERSIST, REMOVE })
	private List<Product> products;
	
	
	
	public Provider(){}
	
	public Provider(String name,Address address, String partitaIva){
		this.name=name;
		this.address=address;
		this.partitaIva=partitaIva;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
