import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Iproduct} from "../../interfaces/iproduct";
import {HttpProductService} from "../../services/http-product.service";
import {HttpUserService} from "../../services/http-user.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {
  products: Array<Iproduct>;
  account:any;

  constructor(private httpProductService: HttpProductService,
              private httpUserService:HttpUserService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private authService:AuthService) {
  }

  ngOnInit(): void {
    this.httpProductService.httpGetProducts().subscribe(data => {
      this.products = data;

      this.authService.httpGetLoggedUser().then(res =>{
        this.account = res;
        console.log(res);
      })
    });
  }

  async openProductDetail(product: Iproduct) {
    await this.router.navigate([product.id + '/product-detail'],
      {relativeTo: this.activatedRoute});
  }

  addToWishList(accountId:number ,productId:number) {
    this.httpUserService.HttpAddToWishList(accountId,productId).subscribe(res=>{
      console.log(res);
    })
  }
}
