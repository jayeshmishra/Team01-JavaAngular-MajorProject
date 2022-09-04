import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodItemService {

  constructor(private httpClient:HttpClient) { }

  getFoodItems(restaurantId:number):Observable<any>{
    return this.httpClient.get("http://localhost:8080/api/foodapp/fooditem/getFoodItemsByRestaurant/"+restaurantId);
  }

  getFoodItemById(foodId:number){
    return this.httpClient.get("http://localhost:8080/api/foodapp/fooditem/getFoodItem/"+foodId);
  }
}
