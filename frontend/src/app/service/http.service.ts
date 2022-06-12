import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url='';

  constructor(private httpClient:HttpClient) { }

  httpPost <ob> (){

  }


}
