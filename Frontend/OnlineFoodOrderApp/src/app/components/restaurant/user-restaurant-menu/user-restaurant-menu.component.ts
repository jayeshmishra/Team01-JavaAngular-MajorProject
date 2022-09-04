import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FoodItemService } from 'src/app/service/food-item.service';
import { UserCartComponent } from '../../user/user-cart/user-cart.component';
@Component({
  selector: 'app-user-restaurant-menu',
  templateUrl: './user-restaurant-menu.component.html',
  styleUrls: ['./user-restaurant-menu.component.scss'],
  providers:[UserCartComponent]
})
export class UserRestaurantMenuComponent implements OnInit {

 
  public hotels = [];
  public restaurantId:any;
  public restaurantName:any;
  public foodItemList:any;
  constructor(private route : ActivatedRoute,
    private foodItemService:FoodItemService,
    private router:Router,
    private userCartComponent:UserCartComponent) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.restaurantId = params['id']);
    this.route.params.subscribe((params: Params) => this.restaurantName = params['name']);
    this.foodItemService.getFoodItems(this.restaurantId).subscribe(
      data=>{
        console.log(data);
        this.foodItemList=data;
        console.log(this.foodItemList)
      },
      error=>{
        console.log(error);
});
  }

  addToCart(foodId:number){;
    this.router.navigate(['/user-cart' , foodId , 1 , this.restaurantId]);
  }
}
