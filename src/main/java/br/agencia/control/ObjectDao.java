package br.agencia.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.agencia.model.entidadesPersistidas.Agencia;

public class ObjectDao {
	private static Session session;
	private static ObjectDao objectDao;

	public static ObjectDao getObjectDao() {
		if (objectDao == null) {
			objectDao = new ObjectDao();
		}
		return objectDao;
	}

	public static Session getSession() {
		return session;
	}

	public void incluir(Object objetoDao) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(objetoDao);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void alterar(Object objetoDao) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(objetoDao);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void excluir(Object objetoDao) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(objetoDao);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static Object consultarByQuery(String parameterQuery) {
		List<Object> list = new ArrayList<>();
		try {
			session = HibernateUtil.getSession();
			list = session.createQuery(parameterQuery).list();
			for (Object retorno : list) {
				return retorno;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public static List<?> listar(String parameterQuery) {
		List<Object> lista = new ArrayList<Object>();
		try {
			session = HibernateUtil.getSession();
			lista = session.createQuery(parameterQuery).list();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}
}
