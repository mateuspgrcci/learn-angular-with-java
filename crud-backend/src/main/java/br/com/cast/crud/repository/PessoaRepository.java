package br.com.cast.crud.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.crud.entidades.Pessoa;

@Repository
public class PessoaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserirPessoa(Pessoa pessoa) {
		em.persist(pessoa);
	}
}
