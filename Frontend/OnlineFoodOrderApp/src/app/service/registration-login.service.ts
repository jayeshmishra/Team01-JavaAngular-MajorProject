import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IUser } from '../utility/IUser';

@Injectable({
  providedIn: 'root'
})
export class RegistrationLoginService {

  constructor(private _httpClient:HttpClient) { }

  registration(user:any){
    return this._httpClient.post<any>("http://localhost:8080/api/foodapp/registration" , user );
  }

  login(user:any){
    return this._httpClient.post<IUser>("http://localhost:8080/api/foodapp/login" , user );
  }

  restaurantLogin(restaurantOwner:any){
    return this._httpClient.post<any>("http://localhost:8080/api/foodapp/rest/login" , restaurantOwner );
  }
}

