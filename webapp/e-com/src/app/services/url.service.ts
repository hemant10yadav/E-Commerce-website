import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor() {
  }
  appUrl = 'http://localhost:8080/e-com/api';
  productUrl = this.appUrl + '/products';
  loginUrl = this.appUrl + '/auth/login';
  signUpUrl = this.appUrl + '/auth/signUp';
  userUrl = this.appUrl + '/private/user';
  skipInterceptor = {headers: {skip: "true"}};
}
