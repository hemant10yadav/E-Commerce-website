import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  public token='';
  data = {
    username: null,
    password: null
  }
  url='http://localhost:8080/e-com/login/token';

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
  }

  login(){
    this.httpClient.post<any>(this.url, this.data).subscribe(data => {
      this.token= data;
      console.log(this.token);
      alert("Login Successfully")
    },(e)=>{
      alert("Something went wrong");
    })
  }
}
