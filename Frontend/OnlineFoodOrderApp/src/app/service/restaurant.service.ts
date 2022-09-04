import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { IAddRestaurant } from '../utility/IAddRestaurant';
import { IRestaurant } from '../utility/IRestaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private _httpClient:HttpClient , public _matSnackBar:MatSnackBar) { }

  getAllRestaurant():Observable<any>{
    return this._httpClient.get("http://localhost:8080/api/foodapp/rest/allRestaurant");
  }
  getImage(imageName:any) {
    //Make a call to Sprinf Boot to get the Image Bytes.
    return this._httpClient.get('http://localhost:8080/api/foodapp/'+imageName);
  }

  addRestaurant(restaurant:any){
    console.log(restaurant);
    return this._httpClient.post("http://localhost:8080/api/foodapp/rest/addRestaurant" , restaurant);
  }

  addFoodItem(foodItem:any){
    console.log(foodItem);
    return this._httpClient.post("http://localhost:8080/api/foodapp/fooditem/addFoodItem" , foodItem);
  }

  getRestaurant(restaurantId:number){
    return this._httpClient.get("http://localhost:8080/api/foodapp/rest/getRestaurantById/"+restaurantId);
  }
}
