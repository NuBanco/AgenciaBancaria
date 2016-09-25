package br.agencia.model.util;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.Pessoa;
import br.agencia.model.entidadesPersistidas.Usuario;

public class ContaFacade {

	public ContaFacade(Pessoa pessoa, Usuario usuario, Conta conta){
		criarPessoa(pessoa);
		criarUsuario(usuario);
		criarConta(conta);
	}

	private void criarConta(Conta conta) {
		GenericDao.getGenericDao().incluir(conta);
	}

	private void criarUsuario(Usuario usuario) {
		GenericDao.getGenericDao().incluir(usuario);
	}

	private void criarPessoa(Pessoa pessoa) {
		GenericDao.getGenericDao().incluir(pessoa);
	}
}
