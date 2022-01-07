package org.gleplant.herdManager.dal;



import java.util.List;

import javax.persistence.RollbackException;

import org.gleplant.herdManager.bo.Color;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ColorDAOJDBCImpl {
	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		session = factory.openSession();
	}

	public static List<Color> selectAll() {
		return session.createQuery("from Color", Color.class).list();
	}

	public static void insert(Color color) {
		Transaction t = session.beginTransaction();
		try {
			session.save(color);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}

	public static void update(Color color) {
		Transaction t = session.beginTransaction();
		try {
			session.update(color);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}
	
	public static void delete(Color color) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(color);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}
}
