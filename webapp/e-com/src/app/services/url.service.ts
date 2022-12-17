import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root',
})
export class UrlService {
	public appUrl: string = 'http://localhost:8080/e-com/api';
	public productUrl: string =
		this.appUrl + '/public/products';
	public loginUrl: string = this.appUrl + '/public/login';
	public signUpUrl: string = this.appUrl + '/public/signup';
	public userUrl: string = this.appUrl + '/auth/user';
	public skipInterceptor: {
		headers: { skip: string };
	} = { headers: { skip: 'true' } };
}
