package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name="getAdminByEmail", query = "SELECT x FROM Admin x WHERE x.email = :emailX")
})

public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//@Column (nullable=false)
	private String firstname;
	//@Column (nullable=false)
	private String lastname;
	
	@Column(nullable=false, unique=true)
	private String email;
	//@Column (nullable=false)
	private String password;

		
		
		public Admin() {}
		
		public Admin(String fname, String lname,String email,String password) {
			this.firstname = fname;
			this.lastname = lname;
			this.email = email;
			this.password = password;
		}
		

		public Long getId() {
			return id;
		}
		/*public void setId(Long id) {
			this.id = id;
		}*/
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
