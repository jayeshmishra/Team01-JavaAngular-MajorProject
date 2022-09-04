import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';
import { RestaurantService } from 'src/app/service/restaurant.service';

@Component({
  selector: 'app-all-restaurants',
  templateUrl: './all-restaurants.component.html',
  styleUrls: ['./all-restaurants.component.scss']
})
export class AllRestaurantsComponent implements OnInit {

  constructor(private restaurantService:RestaurantService,
    private router:Router,
    private adminService:AdminService,
    private _matSnackBar:MatSnackBar) { }

    restaurantList:any
    admin:any;
  ngOnInit(): void {
    this.admin=localStorage.getItem('admin');
  this.restaurantService.getAllRestaurant().subscribe(
    data=>{
      console.log(data);
      this.restaurantList=data;
      console.log(this.restaurantList)
    },
    error=>{
      console.log(error);
});
  }
  displayedColumns: string[] = ['restaurantId' , 'restaurantName' , 'restaurantUserName' , 'restaurantEmail' , 'distance' , 'area' , 'street' , 'pincode' ,'update' ,'delete'];

  updateRestaurant(restaurantId:any){
    console.log(restaurantId);
    this.router.navigate(['/update-restaurant' , restaurantId]);
  }

  deleteRestaurant(restaurantId:any){
    console.log(restaurantId);
    this.adminService.deleteRestaurant(restaurantId).subscribe(
      (data)=>{
        console.log(data);
        window.location.reload();
      },
      (error)=>{
        console.log(error);
        window.location.reload();
      }
    )
   
  }
  logoutAdmin(){
    
    this._matSnackBar.open("Admin Logged Off", "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });  
    localStorage.removeItem('admin');
    this.router.navigate([''])

  }
}
