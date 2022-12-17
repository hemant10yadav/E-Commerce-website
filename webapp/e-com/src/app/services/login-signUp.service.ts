import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { AuthService } from './auth.service';
import { map, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Iuser } from '../interfaces/iuser';

@Injectable({
	providedIn: 'root',
})
export class LoginSignUpService {
	constructor(
		private httpClient: HttpClient,
		private urlService: UrlService,
		private authService: AuthService,
		private router: Router
	) {}

	doLogin(data: any) {
		this.httpClient
			.post<any>(
				this.urlService.loginUrl,
				data,
				this.urlService.skipInterceptor
			)
			.subscribe(
				data => {
					this.authService.saveUser(data.token);
					this.authService.httpGetLoggedUser();
				},
				error => {
					console.log(error);
				}
			);
	}

	doSignUp(data: any): Observable<any> {
		return this.httpClient
			.post(
				this.urlService.signUpUrl,
				data,
				this.urlService.skipInterceptor
			)
			.pipe(map((response: any) => response));
	}

	goToLoginPage() {
		this.router.navigateByUrl('login');
	}

	goToSignupPage() {
		this.router.navigateByUrl('signup');
	}

	checkUsername(username: string): Observable<any> {
		return this.httpClient
			.post(
				this.urlService.appUrl + '/public/username/' + username,
				null,
				this.urlService.skipInterceptor
			)
			.pipe(map((response: any) => response));
	}
}
