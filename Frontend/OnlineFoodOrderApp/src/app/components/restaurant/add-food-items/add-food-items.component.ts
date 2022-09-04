import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RestaurantService } from 'src/app/service/restaurant.service';

@Component({
  selector: 'app-add-food-items',
  templateUrl: './add-food-items.component.html',
  styleUrls: ['./add-food-items.component.scss']
})
export class AddFoodItemsComponent implements OnInit {

  constructor(private fb:FormBuilder ,
    private router:Router , 
    private restaurantService:RestaurantService,
    private httpClient:HttpClient,
    private route:ActivatedRoute
   ) { }

   public myParam:any;

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.myParam = params['id']);
  }
  foodItemForm:FormGroup=this.fb.group({       
    foodId: [''],
    foodName: [''],
    price: [''],
    offer: [''],
    foodCategory: [''],
    foodDescription: [''],
    restaurantId: [''],
  })

  onSubmit(){
    this.foodItemForm.value.restaurantId=this.myParam;
    console.log(this.foodItemForm.value);
    this.restaurantService.addFoodItem(this.foodItemForm.value).subscribe(data=>{
      console.log(data);
      this.router.navigate(['/restaurant-menu', this.myParam]);
    });
    
  }
}
