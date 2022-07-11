import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../../services/auth.service';
import {Iuser} from '../../../interfaces/iuser';
import {Router} from '@angular/router';

@Component({
   selector: 'app-account-dropdown',
   templateUrl: './account-dropdown.component.html',
   styleUrls: ['./account-dropdown.component.scss'],
})
export class AccountDropdownComponent implements OnInit {
   public user: Iuser | null;
   public isLoggedIn = false

   constructor(public authService: AuthService,
               private router: Router) {}

   ngOnInit(): void {}

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
}
