import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {map} from "rxjs";
import {HttpService} from "../../services/http.service";
import {Iproduct} from "../../interfaces/iproduct";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  public product: Iproduct;
  displayImage: string;

  constructor(private activatedRoute:ActivatedRoute,
              private router:Router,
              private httpService:HttpService) { }

  ngOnInit(): void {
    const hem = this.activatedRoute.snapshot.params['id'];
    this.httpService.httpGetProductById(hem).subscribe(data => {
     this.product = data;
     this.displayImage = this.product.image[0]
    });
  }

  changeDisplayImage(event:any, index:number) {
    this.displayImage = this.product.image[index];
  }

  addToCart() {

  }

  addToWishlist() {

  }
}
