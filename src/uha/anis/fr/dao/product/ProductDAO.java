package uha.anis.fr.dao.product;

import java.util.List;

import uha.anis.fr.entities.Product;

public interface ProductDAO {
	void addProduct(Product product);

	List<Product> getProducts();

	void updateProduct(Product product);

	void deleteProduct(Product product);

	Product getProductById(int id);

	long getNumberProducts();

	List<Product> getProductsByCategory(int id);
}
