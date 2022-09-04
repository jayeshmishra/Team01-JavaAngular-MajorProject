import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.scss']
})
export class AdminHomeComponent implements OnInit {

  constructor(private router:Router,
    private _matSnackBar:MatSnackBar) { }
  admin:any;
  ngOnInit(): void {
    this.admin=localStorage.getItem('admin');
  }

  logoutAdmin(){
    
    this._matSnackBar.open("Admin Logged Off", "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });  
    localStorage.removeItem('admin');
    this.router.navigate([''])

  }

}
