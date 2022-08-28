import { HttpClient , HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { IUser } from '../utility/IUser';

@Injectable({
  providedIn: 'root'
})
export class RegistrationLoginService {

  constructor(private _httpClient:HttpClient , public _matSnackBar:MatSnackBar) { }

  registration(user:any){
    return this._httpClient.post<any>("http://localhost:8080/api/foodapp/registration" , user );
  }

  login(user:any){
    return this._httpClient.post<IUser>("http://localhost:8080/api/foodapp/login" , user );
  }
}

