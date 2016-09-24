package br.agencia.model;

import br.agencia.control.GenericDao;

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
