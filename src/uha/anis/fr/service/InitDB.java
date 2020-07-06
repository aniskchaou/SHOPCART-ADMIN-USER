package uha.anis.fr.service;

import uha.anis.fr.dao.category.CategoryDAO;
import uha.anis.fr.dao.category.CategoryDAOImpl;
import uha.anis.fr.dao.product.ProductDAO;
import uha.anis.fr.dao.product.ProductDAOImpl;
import uha.anis.fr.dao.user.UserDAO;
import uha.anis.fr.dao.user.UserDAOImpl;
import uha.anis.fr.entities.Category;
import uha.anis.fr.entities.Product;
import uha.anis.fr.entities.User;

public class InitDB {

	public void insertData(){
	insertUsers();
	insertCategories();
	insertProducts();
	}
	
	 void insertCategories() {
		Category category=new Category(1, "Home and Kitchen", "Home and Kitchen");
		Category category2=new Category(2, "Health & Household", "Health & Household");
		Category category3=new Category(3, "Industrial & Scientific", "Industrial & Scientific");
		Category category4=new Category(4, "Electronics", "Electronics");
		Category category5=new Category(5, "Computers", "Computers");
		CategoryDAO categoryDAO=new CategoryDAOImpl();
		categoryDAO.addCategory(category);
		categoryDAO.addCategory(category2);
		categoryDAO.addCategory(category3);
		categoryDAO.addCategory(category4);
		categoryDAO.addCategory(category5);
	}
	void insertProducts() {
		CategoryDAO categoryDAO=new CategoryDAOImpl();
		Product product=new Product(1,"BISSELL Cleanview Swivel Pet Upright ", "save pets; Bissell donates up to 10 dollars to the Bissell ", "1.jpg",99 ,10 ,12 , categoryDAO.getCategoryById(1));
		Product product2=new Product(2, "Philips Sonicare HX9023/65 Genuine C2 , 3 Pack, White", "SUPERIOR CLEAN: Clinically proven to remove up to 7x more plaque ", "2.jpg", 24, 9, 6, categoryDAO.getCategoryById(2));
		Product product3=new Product(3, "USB Type C Cable, Anker [2-Pack, 6 ft] ", "", "3.jpg", 14, 2, 11, categoryDAO.getCategoryById(3));
		Product product4=new Product(4, "Apple AirPods with Wired Charging Case", "Automatically on, automatically connected", "4.jpg", 150, 3, 3, categoryDAO.getCategoryById(4));
		Product product5=new Product(5, "Samsung SSD 860 EVO 1TB 2.5 Inch SATA III ", "Innovative V-Nand Technology: Powered by Samsung V-Nand Technology", "5i.jpg", 139, 11, 2, categoryDAO.getCategoryById(5));
		
		ProductDAO productDAO=new ProductDAOImpl();
		productDAO.addProduct(product);
		productDAO.addProduct(product2);
		productDAO.addProduct(product3);
		productDAO.addProduct(product4);
		productDAO.addProduct(product5);
	}
	void insertUsers() {
		User user1=new User(1, "admin", "admin", "23123123", "face_admin.png", "USA","admin");
		User user2=new User(2, "user", "user", "123123", "user.png", "USA","normal");
		
		UserDAO userDAO=new UserDAOImpl();
		userDAO.addUser(user1);
		userDAO.addUser(user2);
		
	}
}
