import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from '../../models/order';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OrderService{

  constructor(private httpClient : HttpClient){

  }

  orderProduct(order : Order): Observable<string>{
    const httpsOptions = {
      headers : new HttpHeaders({
        'Content-Type' : 'application/json'
      }),
      responseType : 'text' as 'json'
    };

    return this.httpClient.post<string>('http://localhost:8084/api/order', order, httpsOptions);
  }
}

