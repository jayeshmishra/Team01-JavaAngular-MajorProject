import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IAddRestaurant } from '../utility/IAddRestaurant';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  constructor(private http: HttpClient) {
  }

  upload(file: File , restaurant:IAddRestaurant): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);
  console.log(restaurant.restaurantName);
    console.log(file.name);

    const req = new HttpRequest('POST', `http://localhost:8080/api/foodapp/rest/addRestaurant`,restaurant);

    return this.http.request(req);
  }
}
