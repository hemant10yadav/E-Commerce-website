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

   HttpAddToCart(userId:number ,productId: number): Observable<any> {
      return this.httpClient
         .post(this.urlService.appUrl +'/user/' + userId + '/cart/' + productId , {})
         .pipe(map((response: any) => response));
   }

   httpAddToWishlist (userId :number , productId : number) :Observable<any> {
     return this.httpClient.post(this.urlService.appUrl + '/user/' + userId + '/wishlist/' + productId,{})
       .pipe(map((response:any) => response));
   }
}
