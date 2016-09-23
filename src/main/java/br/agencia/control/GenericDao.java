package br.agencia.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.agencia.model.Agencia;

public class GenericDao {
	private static GenericDao genericDao;

	public static GenericDao getGenericDao() {
		if (genericDao == null){
			genericDao = new GenericDao();
		}
		return genericDao;
	}

	public void incluir(Object objetoGeneric) {
		try {
			HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().save(objetoGeneric);
			HibernateUtil.getSession().getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.getSession().close();
		}
	}

	public void alterar(Object objetoGeneric) {
		try {
			HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().update(objetoGeneric);
			HibernateUtil.getSession().getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.getSession().close();
		}
	}

	public void excluir(Object objetoGeneric) {
		try {
			HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().delete(objetoGeneric);
			HibernateUtil.getSession().getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.getSession().close();
		}
	}

	public Object consultarById(int idPesquisa) {
		Object retorno = new Object();
		try {
			retorno = (Object) HibernateUtil.getSession().get(Object.class, idPesquisa);
		} catch (Exception e) {
			HibernateUtil.getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.getSession().close();
		}
		return retorno;
	}

	public static Object consultarByString(String parameterQuery) {
		List<Object> list = new ArrayList<>();
		try {
			HibernateUtil.getSession().beginTransaction();
			list = HibernateUtil.getSession().createQuery(parameterQuery).list();
			for (Object retorno: list) {
	            return retorno;
	        }
		} catch (Exception e) {
			HibernateUtil.getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.getSession().close();
		}
		return null;
	}


	public static List<?> listar(String parameterQuery) {
		List<Object> lista = new ArrayList<Object>();
		try {
			lista = HibernateUtil.getSession().createQuery(parameterQuery).list();
			return lista;
		} catch (Exception e) {
			HibernateUtil.getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.getSession().close();
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
