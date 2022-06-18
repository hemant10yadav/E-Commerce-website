import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignupPageComponent} from "./Pages/signup-page/signup-page.component";
import {LoginPageComponent} from "./Pages/login-page/login-page.component";
import {AddProductsComponent} from "./Pages/add-products/add-products.component";

const routes: Routes = [

  {
    path: 'signup',
  component: SignupPageComponent
  },

  {
    path: 'login',
  component: LoginPageComponent
  },

  {
    path: 'add-products',
    component: AddProductsComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
