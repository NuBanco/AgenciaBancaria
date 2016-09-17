package br.agencia.control;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class GenericDao {
	private Session session;

	public void incluir(Object objetoGeneric) {
		try {
			session = (Session) HibernateUtil.getSession();
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
			session = (Session) HibernateUtil.getSession();
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
			session = (Session) HibernateUtil.getSession();
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
			session = (Session) HibernateUtil.getSession();
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

	@SuppressWarnings("deprecation")
	public Object consultarByString(Object objetoGeneric, String textoPesquisa) {
		Object retorno = new Object();
		try {
			session = (Session) HibernateUtil.getSession();
			session.beginTransaction();
			retorno = (Object) session.createCriteria(objetoGeneric.getClass()).add(Restrictions.isEmpty(textoPesquisa)).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return retorno;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Object> listar() {
		List<Object> lista = new ArrayList<Object>();
		try {
			session = (Session) HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Object>) session.createCriteria(Object.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
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
