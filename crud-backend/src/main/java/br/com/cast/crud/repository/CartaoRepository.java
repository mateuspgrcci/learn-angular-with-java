package br.com.cast.crud.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.crud.entidades.Cartao;

@Repository
public class CartaoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Cartao> buscarCartoes(){
		Query query = em.createQuery("select c from " + Cartao.class.getName() 
									 + " c "
									 + "join fetch c.id_pessoa");
		return query.getResultList();
	}
	
	public Cartao buscarCartao(String numero) {
		Query query = em.createQuery("from " + Cartao.class.getName() + " where numero = (:numero)");
		query.setParameter("numero", numero);
		try {
			return (Cartao) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void inserirCartao(Cartao cartao) {
		em.persist(cartao);
	}
	
	public void alterarCartao(Cartao cartao) {
		em.merge(cartao);
	}
	
	public void deletarCartao(Cartao cartao) {
		em.remove(cartao);
	}
}
