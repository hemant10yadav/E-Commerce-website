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
    console.log(this.authService.isLoggedIn());
  }

  login() {
    this.loginSignUpService.doLogin(this.data);

    /*  this.httpClient.post<any>(this.url, this.data ,{headers:{skip:"true"}}).subscribe(data => {
      this.token = data.token;
      console.log(this.token);
      this.httpService.token = this.token;
      localStorage.setItem('token', this.token)
      alert("Login Successfully")
    }, (e) => {
      const error = e.error;
      console.log(e.error.message + "  ===  " + e.error.status);
      if (error.status == 404) {
        this.message = 'Username Password invalid'
        this.wrongCredentials = true;
      } else {
        this.wrongCredentials = true;
        this.message = 'Something went wrong'
      }
    })*/
  }

  checkValue() {
    if (this.data.username === '' || this.data.password == '') {
      this.loginDisable = true;
    } else {
      this.loginDisable = false;
    }
    console.log(this.loginDisable);
  }
}
