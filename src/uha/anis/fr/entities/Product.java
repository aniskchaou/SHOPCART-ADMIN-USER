package uha.anis.fr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productt")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 100, name = "p_id")
	int pId;
	@Column(length = 100, name = "p_name")
	String pName;
	@Column(length = 100, name = "p_description")
	String pDescription;
	@Column(length = 100, name = "p_photo")
	String pPhoto;
	@Column(length = 1000, name = "p_price")
	int pPrice;
	@Column(length = 100, name = "p_discount")
	int pDiscount;
	@Column(length = 100, name = "p_quantity")
	int pQuantity;
	@ManyToOne
	Category category_id;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pName, String pDescription, String pPhoto, int pPrice, int pDiscount, int pQuantity,
			Category category) {
		super();
		this.pName = pName;
		this.pDescription = pDescription;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuantity = pQuantity;
		this.category_id = category;
	}

	public Product(int pId, String pName, String pDescription, String pPhoto, int pPrice, int pDiscount, int pQuantity,
			Category category) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuantity = pQuantity;
		this.category_id = category;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getpPhoto() {
		return pPhoto;
	}

	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpDiscount() {
		return pDiscount;
	}

	public void setpDiscount(int pDiscount) {
		this.pDiscount = pDiscount;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pDescription=" + pDescription + ", pPhoto=" + pPhoto
				+ ", pPrice=" + pPrice + ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity + "]";
	}

	public Category getCategory() {
		return category_id;
	}

	public void setCategory(Category category) {
		this.category_id = category;
	}

}
