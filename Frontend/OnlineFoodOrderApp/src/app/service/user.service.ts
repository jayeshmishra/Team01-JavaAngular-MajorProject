import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  userLogout(){
    console.log(localStorage.getItem('currentUser'));
    localStorage.removeItem('currentUser');
  }

  getAllOrdersOfUser(userId:any){
    return this.httpClient.get("http://localhost:8080/api/foodapp/order/getAllOrdersForUser/"+userId);
  }

  getUser(userEmail:any){
    return this.httpClient.get("http://localhost:8080/api/foodapp/getUserByEmail/"+userEmail);
  }
}
