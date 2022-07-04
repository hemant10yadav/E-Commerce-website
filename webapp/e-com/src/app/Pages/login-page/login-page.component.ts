import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpService } from '../../services/http.service';
import { LoginSignUpService } from '../../services/login-signUp.service';
import { AuthService } from '../../services/auth.service';

@Component({
   selector: 'app-login-page',
   templateUrl: './login-page.component.html',
   styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent implements OnInit {
   public token = '';
   data = {
      username: '',
      password: '',
   };
   url = 'http://localhost:8080/e-com/api/login';
   public wrongCredentials = false;
   public loginDisable = true;
   public message: String;

   constructor(
      private httpClient: HttpClient,
      private httpService: HttpService,
      private loginSignUpService: LoginSignUpService,
      private authService: AuthService
   ) {}

   ngOnInit(): void {
   }

   login() {
      this.loginSignUpService.doLogin(this.data);
   }

   checkValue() {
      if (this.data.username === '' || this.data.password == '') {
         this.loginDisable = true;
      } else {
         this.loginDisable = false;
      }
   }
}
