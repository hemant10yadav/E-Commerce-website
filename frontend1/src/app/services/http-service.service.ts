import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient:HttpClient) { }

/*  httpPost(url:string,data?:any){
   return new Promise<Observable<any>>(()=> {
       this.httpClient.post<any>(url, data)
     }
   );}*/
}
