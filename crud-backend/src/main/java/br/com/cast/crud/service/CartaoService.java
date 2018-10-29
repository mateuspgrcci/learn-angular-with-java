package br.com.cast.crud.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.crud.dto.CartaoDTO;
import br.com.cast.crud.dto.PessoaDTO;
import br.com.cast.crud.entidades.Cartao;
import br.com.cast.crud.entidades.Pessoa;
import br.com.cast.crud.repository.CartaoRepository;
import br.com.cast.crud.repository.PessoaRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<CartaoDTO> buscarCartoes(){
		List<Cartao> cartoes = cartaoRepository.buscarCartoes();
		List<CartaoDTO> cartoesDto = new ArrayList<>();
		for (Cartao c : cartoes) {
			CartaoDTO cartaoDto = new CartaoDTO();
			cartaoDto.setNumero(c.getNumero());
			cartaoDto.setValidade(dateToString(c.getValidade()));
			cartaoDto.setSeguranca(c.getSeguranca());
			
			PessoaDTO pessoaDto = new PessoaDTO();
			pessoaDto.setId(c.getId_pessoa().getId());
			pessoaDto.setNome(c.getId_pessoa().getNome());
			pessoaDto.setSobrenome(c.getId_pessoa().getSobrenome());
			pessoaDto.setEmail(c.getId_pessoa().getEmail());
			pessoaDto.setCpf(c.getId_pessoa().getCpf());
			cartaoDto.setId_pessoa(pessoaDto);
			cartoesDto.add(cartaoDto);
		}
		return cartoesDto;
	}
	
	public CartaoDTO buscarCartao(String numero) {
		Cartao c = cartaoRepository.buscarCartao(numero);
		CartaoDTO cartaoDto = new CartaoDTO();
		cartaoDto.setNumero(c.getNumero());
		cartaoDto.setValidade(dateToString(c.getValidade()));
		cartaoDto.setSeguranca(c.getSeguranca());
		
		PessoaDTO pessoaDto = new PessoaDTO();
		pessoaDto.setId(c.getId_pessoa().getId());
		pessoaDto.setNome(c.getId_pessoa().getNome());
		pessoaDto.setSobrenome(c.getId_pessoa().getSobrenome());
		pessoaDto.setEmail(c.getId_pessoa().getEmail());
		pessoaDto.setCpf(c.getId_pessoa().getCpf());
		cartaoDto.setId_pessoa(pessoaDto);

		return cartaoDto;
	}
	
	@Transactional
	public void inserirCartao(CartaoDTO cartaoDto) {
		Cartao cartao = new Cartao();
		cartao.setNumero(cartaoDto.getNumero());
		cartao.setSeguranca(cartaoDto.getSeguranca());
		cartao.setValidade(stringToDate(cartaoDto.getValidade()));
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(cartaoDto.getId_pessoa().getNome());
		pessoa.setSobrenome(cartaoDto.getId_pessoa().getSobrenome());
		pessoa.setEmail(cartaoDto.getId_pessoa().getEmail());
		pessoa.setCpf(cartaoDto.getId_pessoa().getCpf());
		pessoaRepository.inserirPessoa(pessoa);
		
		cartao.setId_pessoa(pessoa);
		
		cartaoRepository.inserirCartao(cartao);
	}
	
	@Transactional
	public void alterarCartao(CartaoDTO cartaoDto) {
		Cartao cartao = new Cartao();
		cartao.setNumero(cartaoDto.getNumero());
		cartao.setSeguranca(cartaoDto.getSeguranca());
		cartao.setValidade(stringToDate(cartaoDto.getValidade()));
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(cartaoDto.getId_pessoa().getId());
		pessoa.setNome(cartaoDto.getId_pessoa().getNome());
		pessoa.setSobrenome(cartaoDto.getId_pessoa().getSobrenome());
		pessoa.setEmail(cartaoDto.getId_pessoa().getEmail());
		pessoa.setCpf(cartaoDto.getId_pessoa().getCpf());
		
		cartao.setId_pessoa(pessoa);
		
		cartaoRepository.alterarCartao(cartao);
	}
	
	@Transactional
	public void removerCartao(String numero) {
		Cartao cartao = cartaoRepository.buscarCartao(numero);
		cartaoRepository.deletarCartao(cartao);
	}
	
	public Date stringToDate(String data) {
		Date dataFormatada = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
	
	public String dateToString(Date date) {
		String dataFormatada = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}

}
