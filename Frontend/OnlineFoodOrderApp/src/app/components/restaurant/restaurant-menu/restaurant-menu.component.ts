import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FoodItemService } from 'src/app/service/food-item.service';
import { RestaurantService } from 'src/app/service/restaurant.service';

@Component({
  selector: 'app-restaurant-menu',
  templateUrl: './restaurant-menu.component.html',
  styleUrls: ['./restaurant-menu.component.scss']
})
export class RestaurantMenuComponent implements OnInit {

  public hotels = [];
  public restaurantId:any;
  public restaurantName:any;
  public foodItemList:any;
  constructor(private route : ActivatedRoute,
    private foodItemService:FoodItemService,
    private router:Router,
    private restaurantService:RestaurantService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.restaurantId = params['id']);
    this.route.params.subscribe((params: Params) => this.restaurantName = params['name']);
    this.foodItemService.getFoodItems(this.restaurantId).subscribe(
      data=>{
        this.foodItemList=data;
      },
      error=>{
        console.log(error);
});
this.restaurantService.getRestaurant(this.restaurantId).subscribe(
  (data)=>{
    console.log(data);
  },
  (error)=>{
    console.log(error);
  }
);
  }

  goToAddFood(){
    this.router.navigate(['/add-food-item', this.restaurantId]);
  }

}
