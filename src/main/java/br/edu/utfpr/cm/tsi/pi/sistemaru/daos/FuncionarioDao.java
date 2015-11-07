package br.edu.utfpr.cm.tsi.pi.sistemaru.daos;

import javax.persistence.TypedQuery;

import br.edu.utfpr.cm.tsi.pi.sistemaru.model.Funcionario;

public class FuncionarioDao extends JpaDao2<Funcionario, Long> {

	public FuncionarioDao() {
		super(Funcionario.class);
	}

	public Funcionario getAutenticacao(String login, String senha) {

		TypedQuery<Funcionario> query = this
				.getManager()
				.createQuery(
						"SELECT f FROM funcionario as f WHERE f.login = :login AND f.senha = :senha",
						Funcionario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return query.getSingleResult();
	}
}