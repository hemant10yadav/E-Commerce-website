import { Injectable } from '@angular/core';
import {
	ActivatedRouteSnapshot,
	CanActivate,
	Router,
	RouterStateSnapshot,
	UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { rejects } from 'assert';

@Injectable({
	providedIn: 'root',
})
export class ReverseAuthGuard implements CanActivate {
	constructor(
		private authService: AuthService,
		private router: Router
	) {}

	canActivate(
		route: ActivatedRouteSnapshot,
		state: RouterStateSnapshot
	):
		| Observable<boolean | UrlTree>
		| Promise<boolean | UrlTree>
		| boolean
		| UrlTree {
		return new Promise(resolve => {
			this.authService.httpGetLoggedUser().then(
				loggedIn => {
					this.router.navigateByUrl('/home');
				},
				rejects => {
					resolve(true);
				}
			);
		});
	}
}
