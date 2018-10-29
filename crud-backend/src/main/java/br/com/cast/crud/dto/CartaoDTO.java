package br.com.cast.crud.dto;

public class CartaoDTO {
	private String numero;
	private String validade;
	private String seguranca;
	private PessoaDTO id_pessoa;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public String getSeguranca() {
		return seguranca;
	}
	public void setSeguranca(String seguranca) {
		this.seguranca = seguranca;
	}
	public PessoaDTO getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(PessoaDTO id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
}
