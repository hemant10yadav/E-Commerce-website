import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  constructor() {
  }
  appUrl = 'http://localhost:8080/e-com/api';
  productUrl = this.appUrl + '/products';
  loginUrl = this.appUrl + '/login';
  signUpUrl = this.appUrl + '/signUp';
  userUrl = this.appUrl + '/auth/user';
  skipInterceptor = {headers: {skip: "true"}};
}
