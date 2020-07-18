package uha.anis.fr.dao.category;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import uha.anis.fr.entities.Category;
import uha.anis.fr.helper.FactoryProvider;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public void addCategory(Category category) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Transaction transaction = hibernaSession.beginTransaction();
		hibernaSession.save(category);
		transaction.commit();
		hibernaSession.close();

	}

	@Override
	public List<Category> getCategories() {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Query query = hibernaSession.createQuery("from Category");
		List<Category> list = query.list();
		return list;
	}

	@Override
	public Category getCategoryById(int id) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Category category = hibernaSession.get(Category.class, id);
		hibernaSession.close();
		return category;
	}

	@Override
	public void UpdateCategory(Category category) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Transaction transaction = hibernaSession.getTransaction();
		transaction.begin();
		hibernaSession.saveOrUpdate(category);
		transaction.commit();
		hibernaSession.close();
	}

	@Transactional
	@Override
	public void deteleCategory(Category category) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Transaction transaction = hibernaSession.getTransaction();
		transaction.begin();
		/*
		 * Query q = hibernaSession.createQuery("delete Category  where cat_id =:cat");
		 * q.setParameter("cat", category.getCategoryId()); q.executeUpdate();
		 */
		hibernaSession.delete(category);
		transaction.commit();
		hibernaSession.close();
	}

	@Override
	public long getNumberCategory() {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Query query = hibernaSession.createQuery("select count(*) from Category");
		Long number = (Long) query.uniqueResult();
		return number;
	}

}
