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
export class MainAuthGuard implements CanActivate {
	private value: boolean;

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
				res => {
					resolve(true);
				},
				error => {
					this.router.navigateByUrl('/login');
					resolve(false);
				}
			);
		});
	}
}
