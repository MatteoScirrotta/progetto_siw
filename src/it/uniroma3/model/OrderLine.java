package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class OrderLine {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Float unitPrice;
	private int quantity;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Product product;
	
	public OrderLine(){}
	
	public OrderLine(Product product){
		this.product=product;
	}
	
	public Float getUnitPrice(){
		return this.unitPrice;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public Product getProduct(){
		return this.product;
	}
	
	public Long getId(){
		return this.id;
	}

	public void setUnitPrice(Float unitPrice){
		this.unitPrice=unitPrice;
	}
	
	public void setQuantity(int quantity){
		if(quantity <= this.product.getInStock())
			this.quantity=quantity;
		else
			this.quantity=this.product.getInStock();
	}
	
	public void setProduct(Product product){
		this.product=product;
	}
}
  