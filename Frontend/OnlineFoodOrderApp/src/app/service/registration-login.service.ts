import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegistrationLoginService {

  constructor(private _httpClient:HttpClient) { }

  registration(tutorial:any){
    return this._httpClient.post<any>("http://localhost:8080/api/foodapp/registration" , tutorial );
  }
}
