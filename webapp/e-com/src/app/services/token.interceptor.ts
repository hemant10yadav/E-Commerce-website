import {Injectable} from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import {Observable} from 'rxjs';
import {HttpService} from "./http.service";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private httpService: HttpService) {
  }


  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (request.headers.get("skip")) {
      return next.handle(request);
    }
    const newRequest = request.clone({
      setHeaders: {
        Authorization: 'Bearer '+ localStorage.getItem('token')
      }
    });
    return next.handle(newRequest);
  }

}
