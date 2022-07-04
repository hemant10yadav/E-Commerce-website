import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { catchError, map, Observable } from 'rxjs';
import { Config } from 'ngx-ui-loader/lib/utils/interfaces';
import { UrlService } from './url.service';

@Injectable({
   providedIn: 'root',
})
export class HttpService {
   token: string;

   constructor(private httpClient: HttpClient, private urlService: UrlService) {}

   httpGetProducts(): Observable<any> {
      return this.httpClient
         .get(this.urlService.productUrl, this.urlService.skipInterceptor)
         .pipe(map((response: any) => response));
   }

   httpGetUser(): Observable<any> {
      return this.httpClient
         .get(this.urlService.userUrl + '/59')
         .pipe(map((response: any) => response));
   }

}
