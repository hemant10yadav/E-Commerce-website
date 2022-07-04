import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
   selector: 'app-user-page',
   templateUrl: './user-page.component.html',
   styleUrls: ['./user-page.component.scss'],
})
export class UserPageComponent implements OnInit {

   constructor(
      private router: Router,
      private activatedRoute: ActivatedRoute
   ) {}

   ngOnInit(): void {}

   openUserProfile() {
      this.router.navigate(['/user/user-profile']);
   }
}
