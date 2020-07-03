package uha.anis.fr.dao.product;

import org.hibernate.Session;
import org.hibernate.Transaction;

import uha.anis.fr.entities.Product;
import uha.anis.fr.helper.FactoryProvider;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(Product product) {
		Session hibernaSession=FactoryProvider.getSessionFactory().openSession();
		Transaction  transaction=hibernaSession.beginTransaction();
		hibernaSession.save(product);
		transaction.commit();
		hibernaSession.close();
		
	}

}
