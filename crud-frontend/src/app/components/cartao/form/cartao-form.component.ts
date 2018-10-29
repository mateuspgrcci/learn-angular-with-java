import { Component, OnInit } from '@angular/core';
import { Cartao } from '../../model/cartao';
import { CartaoService } from '../../service/cartao.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cartao-form',
  templateUrl: './cartao-form.component.html',
  styleUrls: ['./cartao-form.component.css']
})
export class CartaoFormComponent implements OnInit {


  cartao: Cartao;
  alteracao: boolean = false;

  constructor(private service: CartaoService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    let numero = this.route.snapshot.paramMap.get('numero');
    this.cartao = new Cartao();
    if(numero){
      this.service.buscarCartao(numero).subscribe(cartao => this.cartao = cartao)
      this.alteracao = true;
    }
  }

  salvarCartao(cartao: Cartao){
    if(this.alteracao){
      this.service.alterarCartao(cartao).subscribe();
    }else{
      this.service.inserirCartao(cartao).subscribe();
    }
  }

}
