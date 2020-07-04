package uha.anis.fr.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoryy")
public class Category {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(length = 10,name="cat_id")
	int categoryId;
	@Column(length = 100,name="cat_title")
	String categoryTitle;
	@Column(length = 100,name="cat_description")
	String categoryDescription;
	@OneToMany(mappedBy = "category_id")
	List<Product> products=new ArrayList<Product>();
	public Category() {
		// TODO Auto-generated constructor stub
	}

   

	public Category(String categoryTitle, String categoryDescription) {
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}

   

	public Category(int categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}



	public Category(int categoryId, String categoryTitle, String categoryDescription, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.products = products;
	}



	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + "]";
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
	
	
}
