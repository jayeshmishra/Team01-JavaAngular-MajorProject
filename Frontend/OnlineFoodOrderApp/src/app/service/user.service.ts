import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  userLogout(){
    console.log(localStorage.getItem('currentUser'));
    localStorage.clear();
  }
}
