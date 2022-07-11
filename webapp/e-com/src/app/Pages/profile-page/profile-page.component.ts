import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
   selector: 'app-profile-page',
   templateUrl: './profile-page.component.html',
   styleUrls: ['./profile-page.component.scss'],
})
export class ProfilePageComponent implements OnInit {
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
