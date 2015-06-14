package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="cFacade")
public class CustomerFacade {
	
	@PersistenceContext(unitName = "unit-jee-es2")
    private EntityManager em;
	
	public Customer createCustomer(String fname, String lname, String email, String pwd,String phoneNumber,Address address,Date dateOfBirth) {
		Customer customer= new Customer(fname, lname, email, pwd,phoneNumber,address);
		if(dateOfBirth != null)
			customer.setDateOfBirth(dateOfBirth);
		customer.setAddress(address);
		em.persist(customer);
		return customer;
	}
	
	public Customer getCustomer(Long id) {
	    Customer customer = em.find(Customer.class, id);
		return customer;
	}
	
	public List<Customer> getAllCustomers() {
        CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
        cq.select(cq.from(Customer.class));
        List<Customer> customers = em.createQuery(cq).getResultList();
		return customers;
	}
	
	public void updateCustomer(Customer customer) {
        em.merge(customer);
	}
	
    private void deleteCustomer(Customer customer) {
        em.remove(customer);
    }

	public void deleteCustomer(Long id) {
		Customer customer = em.find(Customer.class, id);
        deleteCustomer(customer);
	}
	
	public Customer checkLogin(String email,String password){
		Query query=em.createNamedQuery("getCustomerByEmail");
		query.setParameter("emailX", email);
		Customer customer=(Customer)query.getSingleResult();
		if(customer != null){
			if(customer.getPassword().equals(password))
				return customer;
		}
		return null;
	}


}
