import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpService } from '../../services/http.service';
import { LoginSignUpService } from '../../services/login-signUp.service';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.scss'],
})
export class SignupPageComponent implements OnInit {
  data = {
    firstName: null,
    lastName: null,
    email: null,
    password: null,
    dob: null,
    username: null,
  };
  confirmPassword: string;

  ngOnInit(): void {}

  constructor(private loginSignUpService: LoginSignUpService) {}

  submit(data: any) {
    console.log(data);
    this.loginSignUpService.doSignUp(this.data).subscribe(
      data => {
        alert('User Registration is done successfully');
      },
      e => {
        alert('Something went wrong');
      }
    );
  }
}
