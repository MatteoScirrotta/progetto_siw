package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


@Stateless(name="prFacade")

public class ProviderFacade {
	
	@PersistenceContext(unitName = "unit-jee-es2")
    private EntityManager em;

	
	public Provider createProvider(String name,Address address, String partitaIva){
		Provider provider=new Provider(name,address,partitaIva);
		em.persist(provider);
		return provider;
	}
	
	public List<Provider> getAllProviders(){
		 CriteriaQuery<Provider> cq = em.getCriteriaBuilder().createQuery(Provider.class);
	        cq.select(cq.from(Provider.class));
	        List<Provider> providers = em.createQuery(cq).getResultList();
			return providers;
	}
	
	public void updateProvider(Provider provider) {
        em.merge(provider);
	}
	
    private void deleteCustomer(Provider provider) {
        em.remove(provider);
    }

	public void deleteCustomer(Long id) {
		Provider provider = em.find(Provider.class, id);
        deleteCustomer(provider);
	}
}
