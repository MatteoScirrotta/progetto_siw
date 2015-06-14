package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="aFacade")
public class AdminFacade {

	@PersistenceContext(unitName = "unit-jee-es2")
    private EntityManager em;
	
	public Admin createAdmin(String firstname,String lastname,String email,String password){
		Admin admin=new Admin(firstname,lastname,email,password);
		em.persist(admin);
		return admin;
	}
	
	public void updateAdmin(Admin admin) {
        em.merge(admin);
	}
	
    private void deleteAdmin(Admin admin) {
        em.remove(admin);
    }

	public void deleteAdmin(Long id) {
		Admin admin = em.find(Admin.class, id);
        deleteAdmin(admin);
	}
	
	public Admin checkLogin(String email,String password){
		Query query=em.createNamedQuery("getAdminByEmail");
		query.setParameter("emailX", email);
		Admin admin=(Admin)query.getSingleResult();
		if(admin != null){
			if(admin.getPassword().equals(password))
				return admin;
		}
		return null;
	} 
	
	/*public Admin checkLogin(String email,String password){
		List<Admin> admins=getAllAdministrators();
		for(Admin a:admins){
			if(a.getEmail().equals(email))
				return a;
		}
		return null;
	} */
	
	public Admin getAdmin(Long id) {
	    Admin admin = em.find(Admin.class, id);
		return admin;
	}
	
	
	
	public List<Admin> getAllAdministrators() {
        CriteriaQuery<Admin> cq = em.getCriteriaBuilder().createQuery(Admin.class);
        cq.select(cq.from(Admin.class));
        List<Admin> administrators = em.createQuery(cq).getResultList();
		return administrators;
	}
}
