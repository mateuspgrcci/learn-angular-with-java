import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CartaoRoutingModule } from './cartao-routing.module';
import { CartaoFormComponent } from './form/cartao-form.component';
import { CartaoListComponent } from './list/cartao-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    CartaoRoutingModule,
    FormsModule
  ],
  declarations: [CartaoFormComponent, CartaoListComponent]
})
export class CartaoModule { }
