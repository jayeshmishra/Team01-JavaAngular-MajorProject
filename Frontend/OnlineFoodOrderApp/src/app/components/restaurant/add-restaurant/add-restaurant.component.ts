import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { RestaurantService } from 'src/app/service/restaurant.service';

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.scss']
})
export class AddRestaurantComponent implements OnInit {

  constructor(private fb:FormBuilder ,
    private _router:Router , 
    private restaurantService:RestaurantService,
    private httpClient:HttpClient
   ) { }

  ngOnInit(): void {
  }

  restaurantForm:FormGroup=this.fb.group({       
    restaurantId: [''],
    restaurantName: [''],
    restaurantUserName: [''],
    restaurantPassword: [''],
    restaurantEmail: [''],
    attemptCount: [''],
    distance: [''],
    area: [''],
    street: [''],
    pincode: [''],
  })

  onSubmit(){
    console.log(this.restaurantForm.value);
    this.restaurantService.addRestaurant(this.restaurantForm.value).subscribe(data=>{
      console.log(data);
    });
    
  }

}
