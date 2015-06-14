package it.uniroma3.beanController;

import it.uniroma3.model.Admin;
import it.uniroma3.model.AdminFacade;
import it.uniroma3.model.Provider;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AdminController {
 
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Admin admin;
	private boolean log;
	
	@EJB(beanName="aFacade")
	private AdminFacade adminFacade;
	
	public AdminController(){}
	
	public String createAdmin(){
		this.admin=adminFacade.createAdmin(firstname, lastname, email, password);
		return "adminHome";
	}
	
	public String newAdmin(){
		return "newAdmin";
	}
	
	public String checkLogin(){
		admin=adminFacade.checkLogin(email, password);
		if(admin == null)
			return "loginAdmin";
		log=true;
		email="";
		password="";
		return "adminHome";
	}
	
	public String logout(){
		log=false;
		email="";
		password="";
		return "index";
	}
	
	public String goHome(){
		return "adminHome";
	}
	
	public String addProduct(Provider provider){
		return "chooseProvider";
	}
	
	public Admin getAdmin(){
		return admin;
	}
	
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	
	public boolean getLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String fname) {
		this.firstname = fname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lname) {
		this.lastname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
