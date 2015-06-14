package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="oFacade")
public class OrderFacade {

	@PersistenceContext(unitName = "unit-jee-es2")
    private EntityManager em;
	
	
	public Order createOrder(Customer customer){
		Order order=new Order(customer);
		return order;
	}
	
	public Order closeOrder(Order order){
		order.setState();//se lo state is a 0 va ad 1 e viceversa
		order.setTerminationTime(new Date());
		updateOrder(order);
		updateCatalog(order);
		return order;
		}
	
	private void updateCatalog(Order order){
		Product product;
		int availability;
		for(OrderLine ol: order.getOrderLines()){
			product=ol.getProduct();
			availability=product.getInStock();
			product.setInStock(availability-ol.getQuantity());
			em.merge(product);
		}
	}
	
	public List<Order> getOpenOrders(){
		Query query=em.createNamedQuery("getOpenOrders");
		query.setParameter("terminationTimeX", null);
		@SuppressWarnings("unchecked")
		List<Order> openOrders=query.getResultList();
		return openOrders;
	}
	
	public boolean checkAvailability(Order order){
		for(OrderLine o:order.getOrderLines()){
			if(!checkAvailability(o))
				return false;
		}
		return true;
	}
		
	
	private boolean checkAvailability(OrderLine orderLine){
		Product product=orderLine.getProduct();
		product=em.find(Product.class, product.getId());
		if(product.getInStock() >= orderLine.getQuantity())
			return true;
		return false;
	}
	
	public OrderLine createOrderLine(Product product){
		OrderLine orderLine= new OrderLine(product);
		return orderLine;
	}
	
	public Order getOrder(Long id){
		 Order order = em.find(Order.class, id);
			return order;
	}
	
	public void updateOrder(Order order) {
        em.merge(order);
	}
	
    private void deleteOrder(Order order) {
        em.remove(order);
    }

	public void deleteOrder(Long id) {
		Order order = em.find(Order.class, id);
        deleteOrder(order);
	}
	
	public void updateCustomer(Customer customer){
		em.merge(customer);
	}
	
	public Order persistOrder(Order order){
		order.setTotal();
		em.persist(order);
		return order;
	}
	
	public List<Order> getAllOrders() {
        CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
        cq.select(cq.from(Order.class));
        List<Order> orders = em.createQuery(cq).getResultList();
		return orders;
	}
	
	
	
}
