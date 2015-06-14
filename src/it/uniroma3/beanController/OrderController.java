package it.uniroma3.beanController;


import java.util.List;


import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Product;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class OrderController {

	
	private Long id;
	//private Date creationTime;
	//private Date dataChiusura;
	private List<OrderLine> orderLines;
	private Customer customer;
	private OrderLine orderLine;
	private Order order;
	private int quantity;
	private List<Order> orders;
	private List<Order> openOrders;
	private String err;
	private boolean isOpenOrder;
	private boolean availability;
	//private boolean isOld;
	
	@EJB(beanName="oFacade")
	private OrderFacade orderFacade;
	
	public String createOrder(Customer c){
		this.customer=c;
		this.order=orderFacade.createOrder(customer);
		//isOld=false;
		return"newOrder";
	}
	
	public void updateCustomer(){
		order=orderFacade.persistOrder(order);
		customer.getOrders().add(order);
	}
	
	public String terminateOrder(){
		if(order.getOrderLines().isEmpty())
			return "newOrder";
		updateCustomer();
		order=null;
		return "homeCustomer";
	}
	//for admin users
	public String findOpenOrders(){
		openOrders=orderFacade.getOpenOrders();
		isOpenOrder=true;
		return "openOrders";
	}
	
	public String checkAvailabilityOrder(Order order){
		availability=orderFacade.checkAvailability(order);
		this.order=order;
		return"orderDetails";
	}
	
	public String closeOrder(){
		order=orderFacade.closeOrder(order);
		return "orderClosed";
	}
	
	
	public String findOrder(Long id){
		this.order = orderFacade.getOrder(id);
		return "orderDetails";
	}
	
	public String findOrder(Order order){
		this.order = order;
		return "orderDetails";
	} 
	
	/*public String findOrder(Order order,Admin admin){
		this.order = order;
		return "adminOrderDetails";
	} */
	
	public String listOrders() {
		this.orders = orderFacade.getAllOrders();
		isOpenOrder=false;
		return "adminOrders"; 
	}
	
	public String addOrderLine(Product product){
		/*if(quantity<1){
			err="you have not to order 0 products";
			return "product";
		}  */
		this.orderLine=orderFacade.createOrderLine(product);
		orderLine.setQuantity(quantity);
		orderLine.setUnitPrice(product.getPrice());
		order.addOrderLine(orderLine);
		quantity=0;
		//isOld=true;
		return"newOrder";
	}
	
	public String getProduct(OrderLine ol){
		this.orderLine=ol;
		return "orderedProduct";
	}
	
	/*public String getProduct(OrderLine ol,Admin admin){
		this.orderLine=ol;
		return "adminOrderedProduct";
	} */
	
	public String goBack(){
		return "orderDetails";
	}
	
	public String goAdminHome(){
		isOpenOrder=false;
		return "adminHome";
	}
	
	public Long getId() {
		return id;
	}
	
public void setId(Long id) {
		this.id = id;
	}
	/*public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}  */

	/*public boolean getIsOld(){
		return isOld;
	} */
	
	public void setOpenOrder(boolean isOpenOrder) {
		this.isOpenOrder = isOpenOrder;
	}

	/*public void setIsOld(boolean isOld) {
		this.isOld = isOld;
	}  */

	public boolean getAvailability() {
	return availability;
}

public void setAvailability(boolean availability) {
	this.availability = availability;
}

	public boolean getIsOpenOrder() {
	return isOpenOrder;
}

public void setIsOpenOrder(boolean isOpenOrder) {
	this.isOpenOrder = isOpenOrder;
}

	public String getErr() {
	return err;
}

public void setErr(String err) {
	this.err = err;
}

	public Customer getCustomer() {
		return customer;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
/*public Date getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}  */

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}

	public List<Order> getOpenOrders() {
		return openOrders;
	}

	public void setOpenOrders(List<Order> openOrders) {
		this.openOrders = openOrders;
	}

	public void setOrders(List<Order> orders){
		this.orders=orders;
	}
	
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	/*public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	} */
	
	/*public CustomerController getCustomerController() {
		return customerController;
	}

	public void setCustomerController(CustomerController customerController) {
		this.customerController = customerController;
	}  */

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
