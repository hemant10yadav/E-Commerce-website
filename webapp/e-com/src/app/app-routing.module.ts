import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductsComponent } from './Pages/add-products/add-products.component';
import {AuthGuardGuard} from "./services/auth-guard/auth-guard.guard";

const routes: Routes = [
   {
      path: 'user',
      loadChildren: () =>
         import('./Pages/user-page/user-page.module').then(
            m => m.UserPageModule),
     canActivate: [AuthGuardGuard],
   },
   {
      path: 'home',
      loadChildren: () =>
         import('./Pages/home/home.module').then(m => m.HomeModule),
   },
   {
      path: 'signup',
      loadChildren: () =>
         import('./Pages/signup-page/signup-page.module').then(
            m => m.SignupPageModule
         ),
   },

   {
      path: 'login',
      loadChildren: () =>
         import('./Pages/login-page/login-page.module').then(
            m => m.LoginPageModule
         ),
   },

   {
      path: 'add-products',
      component: AddProductsComponent,
   },

   { path: '**',
     redirectTo:'home',
     pathMatch: 'full'
   },

];

@NgModule({
   imports: [RouterModule.forRoot(routes)],
   exports: [RouterModule],
})
export class AppRoutingModule {}
