import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss']
})
export class AllUsersComponent implements OnInit {

  constructor(private router:Router,
    private adminService:AdminService,
    private route:ActivatedRoute,
    private _matSnackBar:MatSnackBar) { }
    panelOpenState = false;
  userList:any;
  blockedUserList:any;
  user:any;
  admin:any;
  ngOnInit(): void {
    this.admin=localStorage.getItem('admin');
    this.adminService.getAllUser().subscribe(
    (data)=>{
      console.log(data);
      this.userList=data;
    },
    (error)=>{
      console.log(error);
    });

    this.adminService.getAllLockedUser().subscribe(
      (data)=>{
        this.blockedUserList=data;
      },
      (error)=>{
        console.log(error);
      }
    )
  }
  displayedColumns: string[] = ['userId' , 'userName' , 'userEmail' , 'userMobileNo' , 'area' , 'street' , 'pincode'];
  displayedColumns1: string[] = ['userId' , 'userName' , 'userEmail' , 'userMobileNo' , 'area' , 'street' , 'pincode' , 'unblock'];

  unblockUser(userId:number){
    console.log(userId);
    this.adminService.unblockUser(userId).subscribe(
    (data)=>{
      this.user=data;
      this._matSnackBar.open(this.user.userName+"Unblocked Successfully", "close", { duration: 2000, panelClass: ['snackBar-success'], horizontalPosition: 'center', verticalPosition: 'top' });
      window.location.reload();
    },
    (error)=>{
      console.log(error)
    }
    )
  }
  logoutAdmin(){
    
    this._matSnackBar.open("Admin Logged Off", "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });  
    localStorage.removeItem('admin');
    this.router.navigate([''])

  }
}
