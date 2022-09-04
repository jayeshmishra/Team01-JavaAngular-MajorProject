import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { RegistrationLoginService } from 'src/app/service/registration-login.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

 
  constructor(private fb:FormBuilder ,
    private _router:Router , 
    private _registrationLoginService:RegistrationLoginService,
    private _matSnackBar:MatSnackBar) { }

  ngOnInit(): void {
  }

  registrationForm:FormGroup=this.fb.group({       
    userName:['', [Validators.required]],
    userPassword:[''],
    userEmail:[''],
    userMobileNo:['']
  })

  onSubmit(){
    console.log(this.registrationForm.value);
    this._registrationLoginService.registration(this.registrationForm.value).subscribe(data=>{
      console.log(data);
      this._matSnackBar.open("Successfully Registered.", "close", { duration: 2000, panelClass: ['snackBar-success'], horizontalPosition: 'center', verticalPosition: 'top' });
      this._router.navigate(["login"])
    });
    
  }
  

}
