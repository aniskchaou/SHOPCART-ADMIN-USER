package uha.anis.fr.dao.product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import uha.anis.fr.entities.Category;
import uha.anis.fr.entities.Product;
import uha.anis.fr.entities.User;
import uha.anis.fr.helper.FactoryProvider;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(Product product) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Transaction transaction = hibernaSession.beginTransaction();
		hibernaSession.save(product);
		transaction.commit();
		hibernaSession.close();

	}

	@Override
	public List<Product> getProducts() {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Query query = hibernaSession.createQuery("from Product");
		List<Product> list = query.list();
		return list;
	}

	@Override
	public void updateProduct(Product product) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Transaction transaction = hibernaSession.getTransaction();
		transaction.begin();
		hibernaSession.saveOrUpdate(product);
		transaction.commit();
		hibernaSession.close();

	}

	@Override
	public void deleteProduct(Product product) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Transaction transaction = hibernaSession.getTransaction();
		transaction.begin();
		/*
		 * Query q = hibernaSession.createQuery("delete Category  where cat_id =:cat");
		 * q.setParameter("cat", category.getCategoryId()); q.executeUpdate();
		 */
		hibernaSession.delete(product);
		transaction.commit();
		hibernaSession.close();

	}

	@Override
	public Product getProductById(int id) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		String query = "from Product where pId =: e";
		Query q = hibernaSession.createQuery(query);
		q.setParameter("e", id);
		Product product = (Product) q.uniqueResult();
		hibernaSession.close();
		return product;
	}

	@Override
	public long getNumberProducts() {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Query query = hibernaSession.createQuery("select count(*) from Product");
		Long number = (Long) query.uniqueResult();
		return number;
	}

	@Override
	public List<Product> getProductsByCategory(int id) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Query query = hibernaSession.createQuery("from Product where category_id_cat_id =: cat");
		query.setParameter("cat", id);
		List<Product> list = query.list();
		return list;
	}

}
