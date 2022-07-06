import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddProductsComponent} from './Pages/add-products/add-products.component';
import {MainAuthGuard} from './services/main-auth-guard/main-auth-guard';
import {ReverseAuthGuard} from "./services/reverse-auth-guard/reverse-auth.guard";

const routes: Routes = [
  {
    path: 'user',
    loadChildren: () =>
      import('./Pages/user-page/user-page.module').then(m => m.UserPageModule),
    canActivate: [MainAuthGuard],
  },
  {
    path: 'products',
    loadChildren: () =>
      import('./Pages/products/products.module').then(m => m.ProductsModule),
  },
  {
    path: 'signup',
    loadChildren: () =>
      import('./Pages/signup-page/signup-page.module').then(m => m.SignupPageModule),
    canActivate: [ReverseAuthGuard]
  },

  {
    path: 'login',
    loadChildren: () =>
      import('./Pages/login-page/login-page.module').then(m => m.LoginPageModule),
    canActivate: [ReverseAuthGuard]
  },

  {
    path: 'add-products',
    component: AddProductsComponent,
    canActivate: [MainAuthGuard],
  },

  {path: '**', redirectTo: 'products', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
