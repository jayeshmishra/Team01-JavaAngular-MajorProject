import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient:HttpClient) { }

  getAllUser(){
    return this.httpClient.get("http://localhost:8080/api/foodapp/allUser")
  }

  getAllLockedUser(){
    return this.httpClient.get("http://localhost:8080/api/foodapp/allLockedUser")
  }

  unblockUser(userId:number){
    return this.httpClient.put("http://localhost:8080/api/foodapp/unblock/"+userId , null);
  }

  deleteRestaurant(restaurantId:number){
    return this.httpClient.delete("http://localhost:8080/api/foodapp/rest/deleteRestaurant/"+restaurantId);
  }
}
