package uha.anis.fr.helper;

import org.hibernate.cfg.Configuration;

import uha.anis.fr.service.InitDB;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import uha.anis.fr.entities.*;

public class FactoryProvider {

	static public List<ProductCart> productCartList;
	public static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {

			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				InitDB init = new InitDB();
				init.insertData();
				productCartList = new ArrayList<ProductCart>();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionFactory;
	}
}
