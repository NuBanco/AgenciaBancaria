package br.agencia.model.util;

import br.agencia.control.ObjectDao;
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
		ObjectDao.getObjectDao().incluir(conta);
	}

	private void criarUsuario(Usuario usuario) {
		ObjectDao.getObjectDao().incluir(usuario);
	}

	private void criarPessoa(Pessoa pessoa) {
		ObjectDao.getObjectDao().incluir(pessoa);
	}
}
