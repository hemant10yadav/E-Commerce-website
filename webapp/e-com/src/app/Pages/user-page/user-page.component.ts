import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
   selector: 'app-user-page',
   templateUrl: './user-page.component.html',
   styleUrls: ['./user-page.component.scss'],
})
export class UserPageComponent implements OnInit {
   constructor(
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private authService: AuthService
   ) {}

   ngOnInit(): void {}

   openUserProfile() {
      this.router.navigate(['/user/user-profile']);
   }

   logout() {
      this.authService.logout();
      this.router.navigateByUrl('/home');
   }
}
