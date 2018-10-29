import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cartao } from '../model/cartao';

const URL_BUSCARTODOS = 'http://localhost:8080/cartoes';
const URL_BUSCARCARTAO = 'http://localhost:8080/cartao/'
const URL_DELETAR = 'http://localhost:8080/cartao/';
const URL_INSERIR = 'http://localhost:8080/cadastro';
const URL_ALTERACAO = 'http://localhost:8080/alteracao'

@Injectable({
  providedIn: 'root'
})
export class CartaoService {

  constructor(private http: HttpClient) { }

  buscarCartoes(): Observable<Cartao[]>{
    return this.http.get<Cartao[]>(URL_BUSCARTODOS);
  }

  buscarCartao(numero: string): Observable<Cartao>{
    return this.http.get<Cartao>(URL_BUSCARCARTAO + numero)
  }

  excluirCartao(numero: string){
    return this.http.delete<Cartao>(URL_DELETAR + numero)
  }

  inserirCartao(cartao: Cartao){
    return this.http.post<Cartao>(URL_INSERIR, cartao);
  }

  alterarCartao(cartao: Cartao){
    return this.http.put<Cartao>(URL_ALTERACAO, cartao);
  }
}
