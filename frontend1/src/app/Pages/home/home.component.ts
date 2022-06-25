import { Component, OnInit } from '@angular/core';
import {HttpServiceService} from "../../services/http-service.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public product:[any];


  constructor(private httpService :HttpServiceService) { }

  ngOnInit(): void {
    this.httpService.httpGetProducts().subscribe((data)=> {
      this.product = data;
      console.log(this.product);
    })
  }

}
