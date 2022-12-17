import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { map, Observable } from 'rxjs';

@Injectable({
	providedIn: 'root',
})
export class HttpProductService {
	constructor(
		private httpClient: HttpClient,
		private urlService: UrlService
	) {}

	public httpGetProducts(): Observable<any> {
		return this.httpClient
			.get(
				this.urlService.productUrl,
				this.urlService.skipInterceptor
			)
			.pipe(map((response: any) => response));
	}

	public httpGetProductById(id: number): Observable<any> {
		return this.httpClient
			.get(
				this.urlService.productUrl + '/' + id,
				this.urlService.skipInterceptor
			)
			.pipe(map((response: any) => response));
	}
}
