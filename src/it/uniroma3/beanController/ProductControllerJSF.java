package it.uniroma3.beanController;

import it.uniroma3.model.Provider;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ProductControllerJSF {
	//@ManagedProperty(value="#{param.id}")
	private Long id;
	private String title;
	private Float price;
	private String description;
	private String code;
	private String author;
	private String genre;
	private Product product;
	private List<Product> products;
	private List<Provider> providers;
	private Provider provider;
	private int inStock;
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;

	public ProductControllerJSF(){
		this.providers=new LinkedList<Provider>();
	}
	
	public String createProduct() {
		this.product = productFacade.createProduct(title, code, price, description, author, genre, inStock, providers);
//		reset();
		return "adminHome"; 
	}
	//resetta le variabili del controller relative all inserimento di un nuovo prodotto per evitare che al successivo inserimento 
	//di un prodotto mi stampi i dati dell ultimo prodotto inserito(all interno della stessa sessione)
	private void reset(){
		title="";
		price=(float) 0;
		description="";
		code="";
		author="";
		genre="";
		inStock=0;
	}
	
	public String addProduct(Provider provider){
		if(providers.contains(provider))
			return"chooseProvider";
		this.providers.add(provider);
		return "chooseProvider";
	}
	
	public String checkData(){
		return "confermeDataProduct";
	}
	
	/*public String goForward(){
		return "index";
	} */
	
	public String listProducts() {
		this.products = productFacade.getAllProducts();
		return "products"; 
	}
	
	public String listProviders(Product product) {
		this.providers = productFacade.getAllProviders(product);
		return "providers"; 
	}
	
	/*public String listProducts(Admin admin) {
		this.products = productFacade.getAllProducts();
		return "adminCatalog"; 
	} */

	public String findProduct() {
		this.product = productFacade.getProduct(this.id);
		return "product";
	}
	
	public String findProduct(Long id) {
		this.product = productFacade.getProduct(id);
		return "product";
	}
	
	/*public String findProduct(Long id,Admin admin) {
		this.product = productFacade.getProduct(id);
		return "adminProduct";
	} */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public int getInStock(){
		return this.inStock;
	}
	
	public void setinStock(int inStock){
		this.inStock=inStock;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
