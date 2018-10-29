package br.com.cast.crud.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="crud", name="cartao")
public class Cartao {
	@Id
	private String numero;
	private Date validade;
	private String seguranca;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa id_pessoa;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public String getSeguranca() {
		return seguranca;
	}
	public void setSeguranca(String seguranca) {
		this.seguranca = seguranca;
	}
	public Pessoa getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(Pessoa id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
}
