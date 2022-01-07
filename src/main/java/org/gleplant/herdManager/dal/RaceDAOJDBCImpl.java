package org.gleplant.herdManager.dal;

import java.util.List;

import javax.persistence.RollbackException;

import org.gleplant.herdManager.bo.Race;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class RaceDAOJDBCImpl {

	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		session = factory.openSession();
	}

	public static List<Race> selectAll() {
		return session.createQuery("from Race", Race.class).list();
	}	

	public static void insert(Race race) {
		Transaction t = session.beginTransaction();
		try {
			session.save(race);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}

	public static void update(Race race) {
		Transaction t = session.beginTransaction();
		try {
			session.update(race);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}
	
	public static void delete(Race race) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(race);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}

}
