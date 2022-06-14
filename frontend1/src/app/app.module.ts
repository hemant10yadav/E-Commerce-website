import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {LoginPageComponent} from './Pages/login-page/login-page.component';
import {SignupPageComponent} from "./Pages/signup-page/signup-page.component";
import {SharedComponentModule} from "./components/shared-components/shared-component.module";
import {NgxUiLoaderModule, NgxUiLoaderRouterModule} from "ngx-ui-loader";
import {TokenInterceptorServiceService} from "./services/token-interceptor-service.service";

@NgModule({
  declarations: [
    AppComponent,
    SignupPageComponent,
    LoginPageComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    SharedComponentModule,
    NgxUiLoaderModule,
    NgxUiLoaderRouterModule.forRoot({
      showForeground:true,
    })

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorServiceService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
