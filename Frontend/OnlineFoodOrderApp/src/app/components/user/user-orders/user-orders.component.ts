import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FoodItemService } from 'src/app/service/food-item.service';
import { OrderService } from 'src/app/service/order.service';
import { UserService } from 'src/app/service/user.service';
import { IOrderDetails } from 'src/app/utility/IOrderDetails';

@Component({
  selector: 'app-user-orders',
  templateUrl: './user-orders.component.html',
  styleUrls: ['./user-orders.component.scss']
})
export class UserOrdersComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private foodItemService:FoodItemService,
    private router:Router,
    private _matSnackBar:MatSnackBar,
    private orderService:OrderService,
    private userService:UserService) { }
    panelOpenState = false;
  cartDetails:any
  totalAmount:any;
  restaurantId:any;
  userId:any;
  allOrders:any;
  orderDetails:IOrderDetails={foodId:[] , userId:0 , restaurantId:0 , total:0};
  userOrderDetails:any;
  foodNames:any[]=[];
  food:any[]=[];
  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.userId = params['userId']);
    this.route.params.subscribe((params: Params) => this.cartDetails = params['cart']);
    this.route.params.subscribe((params: Params) => this.totalAmount = params['amount']);
    this.route.params.subscribe((params: Params) => this.restaurantId = params['restId']);

    //console.log( JSON.parse(JSON.parse(this.cartDetails)[0].foodId));

    for(let i=0 ; i<JSON.parse(this.cartDetails).length; i++){
      this.orderDetails.foodId.push(JSON.parse(JSON.parse(this.cartDetails)[i].foodId));
    }
    this.orderDetails.userId=this.userId;
    this.orderDetails.total=JSON.parse(this.totalAmount);
    this.orderDetails.restaurantId=JSON.parse(this.restaurantId);
   // console.log(this.orderDetails);



    this.orderService.placeOrder(this.orderDetails).subscribe(
      (data)=>{
        this.userOrderDetails=data;
        console.log(data);
      },
      (error)=>{
        console.log(error);
      }
    )

    this.userService.getAllOrdersOfUser(this.userId).subscribe(
      (data)=>{
        this.allOrders = data;
      },
      (error)=>{
        console.log(error);
      }
    )

  }
}
