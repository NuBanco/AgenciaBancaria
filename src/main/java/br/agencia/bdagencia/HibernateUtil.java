package br.agencia.bdagencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static StandardServiceRegistry registry;

	/* Build */
	private static SessionFactory buildSessionFactory() {

		registry = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return sessionFactory;
	}

	/* Metodo Get */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/* Destruir Sessao */
	public static void killSession() {
		StandardServiceRegistryBuilder.destroy(registry);
	}
}