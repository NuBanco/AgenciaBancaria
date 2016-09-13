package br.agencia.database;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.agencia.model.Usuario;

import java.util.List;

public class UsuarioDao {
	private Session session;

	public void incluir(Usuario usuario) {
		try {
			session = (Session) HibernateUtil.getSession();
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void alterar(Usuario usuario) {
		try {
			session = (Session) HibernateUtil.getSession();
			session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void excluir(Usuario usuario) {
		try {
			session = (Session) HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Usuario consultar(int codigo) {
		Usuario retorno = new Usuario();
		try {
			session = (Session) HibernateUtil.getSession();
			session.beginTransaction();
			retorno = (Usuario) session.get(Usuario.class, codigo);
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
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			session = (Session) HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Usuario>) session.createCriteria(Usuario.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar(Usuario usuario) {
		Criteria c = session.createCriteria(Usuario.class);
		if (usuario.getLogin().length() > 0) {
			c.add(Restrictions.like("nome", usuario.getLogin() + "%"));
		}
		c.addOrder(Order.asc("nome"));
		return (List<Usuario>) c.list();
	}
}
