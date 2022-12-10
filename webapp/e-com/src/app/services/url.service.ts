import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor() {
  }
  appUrl = 'http://localhost:8080/e-com/api';
  productUrl = this.appUrl + '/public/products';
  loginUrl = this.appUrl + '/public/login';
  signUpUrl = this.appUrl + '/public/signup';
  userUrl = this.appUrl + '/auth/user';
  skipInterceptor = {headers: {skip: "true"}};
}
