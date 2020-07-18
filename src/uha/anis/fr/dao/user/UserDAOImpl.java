package uha.anis.fr.dao.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import uha.anis.fr.entities.Category;
import uha.anis.fr.entities.User;
import uha.anis.fr.helper.FactoryProvider;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Transaction transaction = hibernaSession.beginTransaction();
		hibernaSession.save(user);
		transaction.commit();
		hibernaSession.close();
	}

	@Override
	public User getUserByEmailPassword(String email, String password) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		String query = "from User where userEmail =: e and userPassword =: p";
		Query q = hibernaSession.createQuery(query);
		q.setParameter("e", email);
		q.setParameter("p", password);
		User user = (User) q.uniqueResult();
		hibernaSession.close();
		return user;
	}

	@Override
	public List<User> getUsers() {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Query query = hibernaSession.createQuery("from User");
		List<User> list = query.list();
		return list;
	}

	@Override
	public void updateUser(User user) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		hibernaSession.saveOrUpdate(user);

	}

	@Override
	public void deleteUser(int id) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		User user = this.getUserById(id);
		hibernaSession.delete(user);

	}

	@Override
	public User getUserById(int id) {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		String query = "from User where userId =: e";
		Query q = hibernaSession.createQuery(query);
		q.setParameter("e", id);
		User user = (User) q.uniqueResult();
		hibernaSession.close();
		return user;
	}

	@Override
	public long getNumberUsers() {
		Session hibernaSession = FactoryProvider.getSessionFactory().openSession();
		Query query = hibernaSession.createQuery("select count(*) from User");
		Long number = (Long) query.uniqueResult();
		return number;
	}

}
