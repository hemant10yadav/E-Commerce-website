import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { AuthService } from './auth.service';
import { map, Observable } from 'rxjs';

@Injectable({
   providedIn: 'root',
})
export class LoginSignUpService {
   constructor(
      private httpClient: HttpClient,
      private urlService: UrlService,
      private authService: AuthService
   ) {}

   doLogin(data: any) {
      this.httpClient
         .post<any>(this.urlService.loginUrl, data, this.urlService.skipInterceptor)
         .subscribe(
            data => {
               this.authService.saveUser(data.token);
            },
            error => {
               console.log(error);
            }
         );
   }

   doSignUp(data: any): Observable<any> {
      return this.httpClient
         .post<any>(this.urlService.signUpUrl, data, this.urlService.skipInterceptor)
         .pipe(map((response: any) => response));
   }
}
