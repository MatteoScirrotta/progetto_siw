package it.uniroma3.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table (name="orders")
@NamedQueries({
@NamedQuery(name="getOpenOrders", query = "SELECT x FROM Order x WHERE x.terminationTime = :terminationTimeX")
})

public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date terminationTime;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = { PERSIST, MERGE, REMOVE })
	@JoinColumn(name="orders_id")
	private List<OrderLine> orderLines;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	private int state;
	private Float total;
	//--------------------------------
		
	public Order(){}
	
	public Order(Customer customer){
		this.total=(float) 0;
		this.creationTime= new Date();
		this.orderLines=new LinkedList<OrderLine>();
		this.customer=customer;
		this.state= 1; //1=open----valutare se farlo diventare stringa o aggiungere al controller una stringa che dipenda dal valore di state
	}
	
	public Date getTerminationTime() {
		return terminationTime;
	}

	public void setTerminationTime(Date terminationTime) {
		this.terminationTime = terminationTime;
	}

	public Long getId(){
		return this.id;
	}
	
	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
	public void setTotal(){
		Float tot;
		for(OrderLine ol: this.orderLines){
			tot=ol.getQuantity() * ol.getUnitPrice();
			this.total += tot;  
		} 
	}

	public Date getCreationTime(){
		return this.creationTime;
	}

	public List<OrderLine> getOrderLines(){
		return this.orderLines;
	}
	
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void addOrderLine(OrderLine o){
		this.orderLines.add(o);
	}

	public Customer getCustomer(){
		return this.customer;
	} 
	
	public void setCustomer(Customer customer){
		this.customer=customer;
	}

	public void setCreationTime(Date creationTime){
		this.creationTime=creationTime;
	}
	
	public int getState(){
		return this.state;
	}
	
	public void setState(){
		if(state==1)
			state=0;
		else
			state=1;
	}
	
	public void setState(int state){
		this.state=state;
	}
	
}   
