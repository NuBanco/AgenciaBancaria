package br.agencia.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.agencia.model.Agencia;

public class GenericDao {
	private static Session session;
	private static GenericDao genericDao;

	public static GenericDao getGenericDao() {
		if (genericDao == null){
			genericDao = new GenericDao();
		}
		return genericDao;
	}

	public void incluir(Object objetoGeneric) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(objetoGeneric);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void alterar(Object objetoGeneric) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(objetoGeneric);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void excluir(Object objetoGeneric) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(objetoGeneric);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Object consultarById(int idPesquisa) {
		Object retorno = new Object();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			retorno = (Object) session.get(Object.class, idPesquisa);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return retorno;
	}


	public static Object consultarByQuery(String parameterQuery) {
		List<Object> list = new ArrayList<>();
		try {
			session = HibernateUtil.getSession();
			list = session.createQuery(parameterQuery).list();
			for (Object retorno: list) {
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

	/*
	 * Verificar se este metodo sera utilizado
	 *
	 * @SuppressWarnings("unchecked") public List<Object> listar(Object
	 * objetoGeneric) { Criteria criteria =
	 * session.createCriteria(Object.class); if
	 * (objetoGeneric.getLogin().length() > 0) {
	 * criteria.add(Restrictions.like("nome", objetoGeneric.getLogin() + "%"));
	 * } criteria.addOrder(Order.asc("nome")); return (List<Object>)
	 * criteria.list(); }
	 */
}
