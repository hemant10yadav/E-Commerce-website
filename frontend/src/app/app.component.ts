import {Component, OnInit} from '@angular/core';
import * as http from "http";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'frontend';
  data ={
    firstName: null,
    lastName :null,
    email : null,
    dob : null,
    username : null,
    password: null,
  }


  ngOnInit() {

  }
  constructor(private httpClient: HttpClient) {
  }


  submit() {
    const url = ''
    this.httpClient.post<any>(url, this.data ).subscribe(data=>{
      console.log(data);
    })
  }
}
