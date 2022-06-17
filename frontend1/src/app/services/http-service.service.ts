import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient:HttpClient) { }

/*  httpPost(url:string,data?:any): Observable<any>{
 return this.httpClient.post(url,data?).pipe(map((response: any)=>{
   response),catchError(err => )
 }))
  }*/
}
