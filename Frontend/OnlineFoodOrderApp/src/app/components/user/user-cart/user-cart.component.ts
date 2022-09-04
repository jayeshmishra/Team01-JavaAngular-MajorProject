import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FoodItemService } from 'src/app/service/food-item.service';
import { ICart } from 'src/app/utility/ICart';
import { IUserCart } from 'src/app/utility/IUserCart';

@Component({
  selector: 'app-user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.scss']
})
export class UserCartComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private foodItemService:FoodItemService,
    private router:Router,
    private _matSnackBar:MatSnackBar) { }
  foodId:any;
  check:any;
  cart:ICart={foodId:0 , quantity:0 , totalAmount:0 };
  cartList:IUserCart={userId:0 , cart:[] , totalAmount:0};
  newCartList:any;
  foodItem:any;
  currentUser:any;
  userId:any;
  key:string | undefined;
  checkCount:number = 0;
  restaurantId:any;
  ngOnInit(): void {
    //this.newCartList = localStorage.getItem("userCart"+localStorage.getItem('currentUser'));
    //this.cartList = JSON.parse(this.newCartList);
    if(localStorage.getItem('currentUser')!=null){
    this.route.params.subscribe((params: Params) => this.foodId = params['id']);
    this.route.params.subscribe((params: Params) => this.check = params['check']);
    this.route.params.subscribe((params: Params) => this.restaurantId = params['restId']);
    this.foodItemService.getFoodItemById(this.foodId).subscribe(
      (data)=>{
        this.currentUser = localStorage.getItem('currentUser');
        this.key="userCart"+this.currentUser;
        this.foodItem=data;
        if(localStorage.getItem(this.key)==null && this.check==1){
        this.cart.foodId=this.foodId;
        this.cart.quantity=1;
        this.cart.totalAmount=this.foodItem.price;
      
        this.cartList.userId = this.currentUser;
        this.cartList.cart.push(this.cart);
        this.cartList.totalAmount= this.cart.totalAmount * this.cart.quantity;
        localStorage.setItem(this.key , JSON.stringify(this.cartList));
        //console.log(this.cartList);
        }else{
          this.newCartList = localStorage.getItem(this.key);
          //console.log(this.newCartList);
          const count = JSON.parse(this.newCartList).cart.length;
         //console.log(count);
          for(let i=0 ; i<JSON.parse(this.newCartList).cart.length; i++){
          if(JSON.parse(this.newCartList).cart[i].foodId==this.foodId){
            console.log(JSON.parse(this.newCartList).cart[i]);
            this.cartList = JSON.parse(this.newCartList);
            this.cartList.cart[i].quantity = this.cartList.cart[i].quantity+1;
            this.foodItem=data;
            this.cartList.cart[i].totalAmount = this.cartList.cart[i].quantity * this.foodItem.price;
            this.cartList.totalAmount= this.cartList.totalAmount + this.foodItem.price;
            //console.log(this.cartList);
            localStorage.setItem(this.key , JSON.stringify(this.cartList));
          }else{
            this.checkCount= this.checkCount+1;
            if(this.checkCount == count){
              this.cartList = JSON.parse(this.newCartList);
              this.cart.foodId=this.foodId;
              this.cart.quantity=1;
              this.cart.totalAmount=this.foodItem.price;
              this.cartList.cart.push(this.cart);
              this.cartList.totalAmount = this.cartList.totalAmount + this.foodItem.price;
            console.log(this.cartList);
            localStorage.setItem(this.key , JSON.stringify(this.cartList));
            }
          }
          }
        }
      },
      (error)=>{
        console.log(error);
      }
    )
    }else{
      this._matSnackBar.open("Please Login To Order !", "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });
      this.router.navigate(['/login']);
    }
  }
  displayedColumns: string[] = ['userId' , 'cart' , 'totalAmount'];

  counter() {
    const i = this.cartList.cart.length;
    return new Array(i);
}

placeOrder(){
  this.newCartList=localStorage.getItem("userCart"+localStorage.getItem('currentUser'));
  this.cartList = JSON.parse(this.newCartList);
  console.log(this.cartList);
  localStorage.removeItem("userCart"+localStorage.getItem('currentUser'));
  this.router.navigate(['/user-orders' , this.cartList.userId , JSON.stringify(this.cartList.cart) , this.cartList.totalAmount , this.restaurantId]);
}

}
