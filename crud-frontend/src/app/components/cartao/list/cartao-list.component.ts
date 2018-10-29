import { Component, OnInit } from '@angular/core';
import { CartaoService } from '../../service/cartao.service';
import { Cartao } from '../../model/cartao';

@Component({
  selector: 'app-cartao-list',
  templateUrl: './cartao-list.component.html',
  styleUrls: ['./cartao-list.component.css']
})
export class CartaoListComponent implements OnInit {

  cartoes: Array<Cartao>

  constructor(private service: CartaoService) { }

  ngOnInit() {
    this.service.buscarCartoes().subscribe(cartao => this.cartoes = cartao)
  }

  excluirCartao(numero: string){
    this.service.excluirCartao(numero).subscribe(cartao => this.ngOnInit())
  }

}
