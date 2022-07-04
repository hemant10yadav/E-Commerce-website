import { Component, OnInit } from '@angular/core';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
   selector: 'app-user-profile',
   templateUrl: './user-profile.component.html',
   styleUrls: ['./user-profile.component.scss'],
})
export class UserProfileComponent implements OnInit {
   public userDetails: any;

   constructor(
      private httpService: HttpService,
      private authService: AuthService,
      private router: Router
   ) {}

   ngOnInit(): void {
      this.check();
   }

   async check() {
      this.authService.httpGetLoggedUser().then(
         resolve => {
                this.userDetails = resolve;
         },
         reject => {
            this.router.navigateByUrl('/home');
         }
      );
   }
}
