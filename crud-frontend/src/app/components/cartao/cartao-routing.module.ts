import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartaoListComponent } from './list/cartao-list.component';
import { CartaoFormComponent } from './form/cartao-form.component';

const routes: Routes = [
  { path: '', component: CartaoListComponent},
  { path: 'cadastro', component: CartaoFormComponent},
  { path: 'cadastro/:numero', component: CartaoFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartaoRoutingModule { }
