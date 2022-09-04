import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurant-owner-home',
  templateUrl: './restaurant-owner-home.component.html',
  styleUrls: ['./restaurant-owner-home.component.scss']
})
export class RestaurantOwnerHomeComponent implements OnInit {

  constructor(private router:Router) { }
  restaurantOwner:any;
  ngOnInit(): void {
    this.restaurantOwner = localStorage.getItem('restaurantOwner');
  }

  logoutRestaurantOwner(){
    localStorage.removeItem('restaurantOwner');
    this.router.navigate([''])
  }
}
