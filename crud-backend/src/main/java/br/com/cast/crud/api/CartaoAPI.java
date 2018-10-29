package br.com.cast.crud.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.crud.dto.CartaoDTO;
import br.com.cast.crud.service.CartaoService;

@RestController
@RequestMapping(path="")
public class CartaoAPI {
	
	@Autowired
	private CartaoService cartaoService;
	
	@GetMapping(path="/cartoes")
	public List<CartaoDTO> buscarCartoes(){
		return cartaoService.buscarCartoes();
	}
	
	@GetMapping(path="/cartao/{numero}")
	public CartaoDTO buscarCartao(@PathVariable("numero") String numero){
		return cartaoService.buscarCartao(numero);
	}
	
	@PostMapping(path="/cadastro")
	public void inserirCartao(@RequestBody CartaoDTO cartaoDto) {
		cartaoService.inserirCartao(cartaoDto);
	}
	
	@PutMapping(path="/alteracao")
	public void alterarCartao(@RequestBody CartaoDTO cartaoDto) {
		cartaoService.alterarCartao(cartaoDto);
	}
	
	@DeleteMapping(path="/cartao/{numero}")
	public void deletarCartao(@PathVariable String numero) {
		cartaoService.removerCartao(numero);
	}
	
}
