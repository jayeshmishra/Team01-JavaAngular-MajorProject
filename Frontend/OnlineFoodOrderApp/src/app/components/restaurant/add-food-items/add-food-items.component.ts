import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
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
    private route:ActivatedRoute,
    private _matSnackBar:MatSnackBar
   ) { }

   public myParam:any;
   restaurantOwner:any;
  ngOnInit(): void {
    this.restaurantOwner = localStorage.getItem('restaurantOwner');
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
  logoutRestaurantOwner(){
    localStorage.removeItem('restaurantOwner');
    this._matSnackBar.open("Logged Out", "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });
    this.router.navigate([''])
  }
}
