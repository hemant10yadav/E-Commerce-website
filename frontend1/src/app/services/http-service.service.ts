import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {catchError, map, Observable} from "rxjs";
import {Config} from "ngx-ui-loader/lib/utils/interfaces";

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  productUrl = 'http://localhost:8080/Spring-helper-backend/api/products'

  constructor(private httpClient: HttpClient) {
  }

  httpGetProducts () : Observable<any>{
    return this.httpClient.get(this.productUrl)
      .pipe(map((response: any) => response));
  }


  /*get(url: string): Observable<any> {
    return this.httpClient.get(this.getRestApiUrl() + url)
      .pipe(map((response: any) => response), catchError(err => this.handleError(err)));
  }*/
}
