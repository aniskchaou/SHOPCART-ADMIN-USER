package uha.anis.fr.dao;





import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import uha.anis.fr.entities.User;
import uha.anis.fr.helper.FactoryProvider;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) {
		Session hibernaSession=FactoryProvider.getSessionFactory().openSession();
		Transaction  transaction=hibernaSession.beginTransaction();
		hibernaSession.save(user);
		transaction.commit();
		hibernaSession.close();
	}

	@Override
	public User getUserByEmailPassword(String email, String password) {
		Session hibernaSession=FactoryProvider.getSessionFactory().openSession();
		String query="from User where userEmail =: e and userPassword =: p";
		Query q=hibernaSession.createQuery(query);
		q.setParameter("e", email);
		q.setParameter("p", password);
		User user=(User) q.uniqueResult();
		hibernaSession.close();
		return user;
	}

}
