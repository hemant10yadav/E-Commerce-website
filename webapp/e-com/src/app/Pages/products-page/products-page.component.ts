import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Iproduct } from '../../interfaces/iproduct';
import { HttpProductService } from '../../services/http-product.service';
import { HttpUserService } from '../../services/http-user.service';
import { AuthService } from '../../services/auth.service';
import { Iuser } from '../../interfaces/iuser';
import {LoginSignUpService} from "../../services/login-signUp.service";

@Component({
   selector: 'app-products-page',
   templateUrl: './products-page.component.html',
   styleUrls: ['./products-page.component.scss'],
})
export class ProductsPageComponent implements OnInit {
   products: Array<Iproduct>;
   user: Iuser;

   constructor(
      private httpProductService: HttpProductService,
      private httpUserService: HttpUserService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private authService: AuthService,
      private loginSignUpService:LoginSignUpService
   ) {}

   ngOnInit(): void {
      this.httpProductService.httpGetProducts().subscribe(data => {
         this.products = data as Iproduct[];
         this.authService.httpGetLoggedUser().then(data => {
            this.user = data as Iuser;
         },error=>{});
      });
   }

   async openProductDetail(product: Iproduct) {
      await this.router.navigate([product.id + '/product-detail'], {
         state: this.user,
         relativeTo: this.activatedRoute,
      });
   }

   addToCart(accountId: number, productId: number) {
     if (this.user) {
       this.httpUserService
         .HttpAddToCart(accountId, productId)
         .subscribe(data => {
           this.user = data as Iuser;
           this.authService.user = data as Iuser;
         });
     } else this.loginSignUpService.goToLoginPage()
   }

   addToWishlist(userId: number, productId: number) {
     if (this.user) {
      console.log('enter ' + userId + productId);
      this.httpUserService
         .httpAddToWishlist(userId, productId)
         .subscribe(data => {
            this.user = data as Iuser;
            this.authService.user = data as Iuser;
         });
     } else this.loginSignUpService.goToLoginPage()
   }

   isInWishlist(id: number): boolean {
      if (this.user) {
         const temp = this.user.wishlist.wishlistProduct.find(
            wishlistProduct => wishlistProduct.productId === id
         );
         if (temp) {
            return true;
         } else return false;
      }
      return false;
   }
}
