import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../services/http.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  constructor(private httpService:HttpService) { }

  ngOnInit(): void {
  }

  callItNow() {
   this.httpService.httpGetUser().subscribe((re)=>{
     console.log(re);
   })
  }
}
