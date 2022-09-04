import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-dash-home',
  templateUrl: './dash-home.component.html',
  styleUrls: ['./dash-home.component.scss']
})
export class DashHomeComponent implements OnInit {

  
  
  
  constructor(private restaurantService:RestaurantService ,
    private router:Router,
    private userService:UserService) { }
  tutorialArray:any;
  currentUser:any;
  
  menuItems: any[] = [
    {
      label: 'Log in',
      icon: 'login',
      path: '/login'
    }
  ]

  ngOnInit(): void {
    this.restaurantService.getAllRestaurant().subscribe(
      data=>{
        this.tutorialArray=data;
      
      },
      error=>{
        console.log(error);
});

this.currentUser = localStorage.getItem('currentUser');
console.log(this.currentUser);
  }

  goToHotel = (hotel:any) => {
    this.router.navigate(['/user-restaurant-menu', hotel.restaurantId , hotel.restaurantName])
  }

  logoutUser(){
    this.userService.userLogout();
    this.router.navigate(['/login']);
  }
}