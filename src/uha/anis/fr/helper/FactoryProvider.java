package uha.anis.fr.helper;



import org.hibernate.cfg.Configuration;

import uha.anis.fr.service.InitDB;

import org.hibernate.SessionFactory;

public class FactoryProvider {
	

	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		try {
			
			if(sessionFactory==null)
			{
			sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			InitDB init=new InitDB();
			init.insertData();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sessionFactory;
	}
}
