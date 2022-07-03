import { Component, OnInit } from '@angular/core';
import { HttpService } from '../../services/http.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  public products: [any];

  constructor(private httpService: HttpService) {}

  ngOnInit(): void {
    this.httpService.httpGetProducts().subscribe(data => {
      this.products = data;
      console.log(this.products);
    });
  }
}
