import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SignupPageComponent} from "./Pages/signup-page/signup-page.component";
import {LoginPageComponent} from "./Pages/login-page/login-page.component";
import {AddProductsComponent} from "./Pages/add-products/add-products.component";
import {HomeComponent} from "./Pages/home/home.component";

const routes: Routes = [
  {
    path: 'user',
    loadChildren: () => import('./Pages/user-page/user-page.module').then(m => m.UserPageModule)
  },
  {
    path: 'home',
    component: HomeComponent
  },
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
  },
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
