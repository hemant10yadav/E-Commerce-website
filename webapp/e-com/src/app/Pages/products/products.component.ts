import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Iproduct } from '../../interfaces/iproduct';
import { HttpProductService } from '../../services/http-product.service';
import { HttpUserService } from '../../services/http-user.service';
import { AuthService } from '../../services/auth.service';
import { Iuser } from '../../interfaces/iuser';

@Component({
   selector: 'app-products',
   templateUrl: './products.component.html',
   styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {
   products: Array<Iproduct>;
   user: Iuser;

   constructor(
      private httpProductService: HttpProductService,
      private httpUserService: HttpUserService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private authService: AuthService
   ) {}

   ngOnInit(): void {
      this.httpProductService.httpGetProducts().subscribe(data => {
         this.products = data as Iproduct[];

         this.authService.httpGetLoggedUser().then(data => {
            this.user = data as Iuser;
         });
      });
   }

   async openProductDetail(product: Iproduct) {
      await this.router.navigate([product.id + '/product-detail'], { state: this.user
         ,relativeTo: this.activatedRoute,
      });
   }

  addToCart(accountId: number, productId: number) {
      this.httpUserService
         .HttpAddToCart(accountId, productId)
         .subscribe(data => {
            this.user = data as Iuser;
         });
   }

  addToWishlist(userId: number , productId :number ) {
    this.httpUserService.httpAddToWishlist(userId , productId).subscribe(data => {
      this.user = data as Iuser;
      console.log(this.user);
    })
  }
}
