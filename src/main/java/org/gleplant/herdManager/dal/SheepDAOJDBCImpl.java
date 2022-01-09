package org.gleplant.herdManager.dal;

import java.util.List;

import javax.persistence.RollbackException;

import org.gleplant.herdManager.bo.Sheep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SheepDAOJDBCImpl {

	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		session = factory.openSession();
	}

	public static List<Sheep> selectAll() {
		return session.createQuery("from Sheep", Sheep.class).list();
	}

	public static Sheep selectById(Integer id) {
		return session.find(Sheep.class, id);
	}

	public static Sheep selectByName(String name) {
		return session.createQuery("from Sheep where name = :param_nom", Sheep.class)
				.setParameter("param_nom", name).getSingleResult();
	}

	public static Sheep insert(Sheep sheep) {
		Transaction t = session.beginTransaction();
		try {
			session.save(sheep);
			session.flush();
			t.commit();
			return sheep;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Sheep update(Sheep sheep) {
		Transaction t = session.beginTransaction();
		try {
			session.update(sheep);
			session.flush();
			t.commit();
			return sheep;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}
	
	public static Sheep delete(Sheep sheep) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(sheep);
			session.flush();
			t.commit();
			return sheep;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}
}
