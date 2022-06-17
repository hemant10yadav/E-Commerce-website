import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.scss']
})
export class SignupPageComponent implements OnInit {
  data = {
    firstName: null,
    lastName: null,
    email: null,
    password: null,
    dob: null,
    username: null
  }
  url = 'http://localhost:8080/Spring-helper-backend/api/signup'
  confirmPassword: string;

  ngOnInit(): void {
  }

  constructor(private httpClient: HttpClient) {
  }

  submit(data:any) {
    console.log(data);
   /* this.httpClient.post<any>(this.url, this.data).subscribe(data => {
      alert("User Registration is done successfully")
    },(e)=>{
      alert("Something went wrong");
    })*/
  }

}
