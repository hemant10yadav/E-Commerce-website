import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpUserService} from "../../../services/http-user.service";
import {AuthService} from "../../../services/auth.service";

@Component({
   selector: 'app-user-profile',
   templateUrl: './user-profile.component.html',
   styleUrls: ['./user-profile.component.scss'],
})
export class UserProfileComponent implements OnInit {
   public user: any;

   constructor(
      private httpService: HttpUserService,
      private authService: AuthService,
      private router: Router
   ) {}

   ngOnInit(): void {
      this.check();
   }

   async check() {
      this.authService.httpGetLoggedUser().then(
         resolve => {
            this.user = resolve;
         },
         reject => {
            this.router.navigateByUrl('/home');
         }
      );
   }
}
