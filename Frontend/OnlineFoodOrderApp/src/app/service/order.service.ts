import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient:HttpClient) { }

  placeOrder(orderDetails:any){
  return this.httpClient.post("http://localhost:8080/api/foodapp/order/place-order", orderDetails);
  }
}
