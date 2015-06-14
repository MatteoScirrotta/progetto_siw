package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


@Stateless(name="pFacade")
public class ProductFacade {
	
	@PersistenceContext(unitName = "unit-jee-es2")
    private EntityManager em;
	
	public Product createProduct(String title, String code, Float price, String description, String author, String genre, int inStock, List<Provider> providers) {
		Product product = new Product(title, price, description, code, author, genre, inStock);
		product.setProviders(providers);
		em.persist(product);
		return product;
	}
	
	public Product getProduct(Long id) {
	    Product product = em.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAllProducts() {
        CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}
	
	public List<Provider> getAllProviders(Product p) {
		Query query=em.createNamedQuery("getProviders");
		query.setParameter("product_idX", p.getId());
		@SuppressWarnings("unchecked")
		List<Provider> providers=query.getResultList();
		return providers;
	} 
	

	public void updateProduct(Product product) {
        em.merge(product);
	}
	
    private void deleteProduct(Product product) {
        em.remove(product);
    }

	public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        deleteProduct(product);
	}
}
