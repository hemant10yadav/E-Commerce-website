import {Injectable} from '@angular/core';
import {AES, enc} from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  joke = 'Are you kidding me?'


  constructor() {
  }

  saveUser(data: any) {
    localStorage.setItem(this.joke, this.encryptString(data, 'tokenValue'));
  }

  isLoggedIn(): boolean {
    if (localStorage.getItem('token')) {
      return true;
    } else return false;
  }

  getAccessToken() {
    const decryptValue = this.decryptString(localStorage.getItem(this.joke), 'tokenValue');
    return decryptValue;
  }

  encryptString(data: any, key: string) {
    return AES.encrypt(data, key).toString();
  }

  decryptString(data: any, key: any) {
    return AES.decrypt(data, key).toString(enc.Utf8);
  }

}
