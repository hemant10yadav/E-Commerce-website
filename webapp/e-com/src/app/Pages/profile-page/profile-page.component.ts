import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Iuser } from '../../interfaces/iuser';

@Component({
	selector: 'app-profile-page',
	templateUrl: './profile-page.component.html',
	styleUrls: ['./profile-page.component.scss'],
})
export class ProfilePageComponent implements OnInit {
	user: Iuser;

	constructor(
		private router: Router,
		private activatedRoute: ActivatedRoute,
		private authService: AuthService
	) {
		this.user = this.router.getCurrentNavigation()?.extras
			.state as Iuser;
	}

	ngOnInit(): void {
		if (!this.user) {
			this.user = this.authService.user as Iuser;
		}
	}

	openUserProfile() {
		this.router.navigate(['/user/user-profile']);
	}

	logout() {
		this.authService.logout();
		this.router.navigateByUrl('/home');
	}
}
