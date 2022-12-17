import { Injectable } from '@angular/core';
import {
	HttpEvent,
	HttpHandler,
	HttpInterceptor,
	HttpRequest,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
	constructor(private authService: AuthService) {}

	intercept(
		request: HttpRequest<unknown>,
		next: HttpHandler
	): Observable<HttpEvent<unknown>> {
		if (request.headers.get('skip')) {
			return next.handle(request);
		}
		const newRequest = request.clone({
			setHeaders: {
				Authorization:
					'Bearer ' + this.authService.getAccessToken(),
			},
		});
		return next.handle(newRequest);
	}
}
