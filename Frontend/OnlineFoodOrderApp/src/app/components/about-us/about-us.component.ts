import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.scss']
})
export class AboutUsComponent implements OnInit {

  constructor() { }
  admin:any;
  currentUser:any;
  restaurantOwner:any;
  ngOnInit(): void {
    this.admin=localStorage.getItem('admin');
    this.currentUser=localStorage.getItem('currentUser');
    this.restaurantOwner=localStorage.getItem('restaurantOwner');
  }

}
