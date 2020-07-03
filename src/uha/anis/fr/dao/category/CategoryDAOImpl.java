package uha.anis.fr.dao.category;

import org.hibernate.Session;
import org.hibernate.Transaction;

import uha.anis.fr.entities.Category;
import uha.anis.fr.helper.FactoryProvider;

public class CategoryDAOImpl implements CategoryDAO{

	@Override
	public void addCategory(Category category) {
		Session hibernaSession=FactoryProvider.getSessionFactory().openSession();
		Transaction  transaction=hibernaSession.beginTransaction();
		hibernaSession.save(category);
		transaction.commit();
		hibernaSession.close();
		
	}

}
