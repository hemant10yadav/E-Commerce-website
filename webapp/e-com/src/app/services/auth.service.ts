import { Injectable } from '@angular/core';
import { AES, enc } from 'crypto-js';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { map } from 'rxjs';

@Injectable({
   providedIn: 'root',
})
export class AuthService {
   joke = 'Are you kidding me?';
   loggedUser: boolean;

   constructor(
      private router: Router,
      private httpClient: HttpClient,
      private urlService: UrlService
   ) {}

   saveUser(data: any) {
      localStorage.setItem(this.joke, this.encryptString(data, 'tokenValue'));
   }

   getAccessToken() {
      if (localStorage.getItem(this.joke)) {
         const decryptValue = this.decryptString(
            localStorage.getItem(this.joke),
            'tokenValue'
         );
         return decryptValue;
      } else return null;
   }

   encryptString(data: any, key: string) {
      return AES.encrypt(data, key).toString();
   }

   decryptString(data: any, key: any) {
      return AES.decrypt(data, key).toString(enc.Utf8);
   }

   httpGetLoggedUser() {
      return new Promise((resolve, reject) => {
         if (this.getAccessToken()) {
            this.httpClient
               .get(this.urlService.userUrl)
               .pipe(map((response: any) => response))
               .subscribe({
                  next: data => resolve(data),
                  error: e => reject(false),
               });
         } else reject(false);
      });
   }

   logout(){
     localStorage.removeItem(this.joke);
   }
}