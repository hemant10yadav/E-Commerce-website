import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { LoginPageComponent } from './Pages/login-page/login-page.component';
import { SignupPageComponent } from './Pages/signup-page/signup-page.component';
import { SharedComponentModule } from './components/shared-components/shared-component.module';
import { NgxUiLoaderHttpModule, NgxUiLoaderModule } from 'ngx-ui-loader';
import { AddProductsComponent } from './Pages/add-products/add-products.component';
import { ProductsComponent } from './Pages/products/products.component';
import { UserPageComponent } from './Pages/user-page/user-page.component';
import { TokenInterceptor } from './services/token.interceptor';

@NgModule({
   declarations: [
      AppComponent,
      SignupPageComponent,
      LoginPageComponent,
      AddProductsComponent,
      ProductsComponent,
      UserPageComponent,
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      FormsModule,
      HttpClientModule,
      SharedComponentModule,
      NgxUiLoaderModule,
      NgxUiLoaderHttpModule.forRoot({
         showForeground: true,
      }),
   ],
   providers: [
      {
         provide: HTTP_INTERCEPTORS,
         useClass: TokenInterceptor,
         multi: true,
      },
   ],
   bootstrap: [AppComponent],
})
export class AppModule {}
