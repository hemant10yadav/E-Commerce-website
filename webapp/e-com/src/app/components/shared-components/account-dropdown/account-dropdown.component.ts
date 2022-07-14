import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { Iuser } from '../../../interfaces/iuser';
import { Router } from '@angular/router';

@Component({
   selector: 'app-account-dropdown',
   templateUrl: './account-dropdown.component.html',
   styleUrls: ['./account-dropdown.component.scss'],
})
export class AccountDropdownComponent {
   public user: Iuser | null;
   public isLoggedIn = false;

   constructor(public authService: AuthService, private router: Router) {}

   async logout() {
      this.user = null;
      this.isLoggedIn = false;
      await this.authService.logout();
   }

   login() {
      this.router.navigateByUrl('/login');
   }

   signup() {
      this.router.navigateByUrl('/signUp');
   }

   openCart(user :any) {
      this.router.navigate(['user',user.id, 'cart'], { state: { user } });
   }

   openWishlist(user: any) {
      this.router.navigate([ '/user/'+ user.id+'/wishlist'], { state: { user } });
   }
}
