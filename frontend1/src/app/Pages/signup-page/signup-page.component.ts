import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.scss']
})
export class SignupPageComponent implements OnInit {
  data = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    dob: '',
    username: ''
  }
  url = 'http://localhost:8080/e-com/api/signup'

  ngOnInit(): void {
  }

  constructor(private httpClient: HttpClient) {
  }

  submit() {
    this.httpClient.post<any>(this.url, this.data).subscribe(data => {
      console.log(data);
    })
  }

}
