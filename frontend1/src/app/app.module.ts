import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {LoginPageComponent} from './Pages/login-page/login-page.component';
import {SignupPageComponent} from "./Pages/signup-page/signup-page.component";
import {SharedComponentModule} from "./components/shared-components/shared-component.module";

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
    SharedComponentModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
