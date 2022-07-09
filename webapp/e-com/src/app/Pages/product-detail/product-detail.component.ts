import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {map} from "rxjs";
import {HttpUserService} from "../../services/http-user.service";
import {Iproduct} from "../../interfaces/iproduct";
import {HttpProductService} from "../../services/http-product.service";

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
              private httpProductService:HttpProductService) { }

  ngOnInit(): void {
    const hem = this.activatedRoute.snapshot.params['id'];
    this.httpProductService.httpGetProductById(hem).subscribe(data => {
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
