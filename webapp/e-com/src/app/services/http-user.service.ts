import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { UrlService } from './url.service';

@Injectable({
   providedIn: 'root',
})
export class HttpUserService {
   token: string;

   constructor(
      private httpClient: HttpClient,
      private urlService: UrlService
   ) {}

   httpGetUser(): Observable<any> {
      return this.httpClient
         .get(this.urlService.userUrl + '/59')
         .pipe(map((response: any) => response));
   }

   HttpAddToWishList(userId:number ,productId: number): Observable<any> {
      return this.httpClient
         .post(this.urlService.userUrl +'/' + userId + '/product/' + productId , {})
         .pipe(map((response: any) => response));
   }
}
