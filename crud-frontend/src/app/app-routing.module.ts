import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
 { path: '', pathMatch: 'full', redirectTo: ''},
 {
   path: 'cartao',
   loadChildren: '../app/components/cartao/cartao.module#CartaoModule'
 }
]
@NgModule({
  imports: [
    RouterModule.forRoot(routes, {useHash: true})
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
