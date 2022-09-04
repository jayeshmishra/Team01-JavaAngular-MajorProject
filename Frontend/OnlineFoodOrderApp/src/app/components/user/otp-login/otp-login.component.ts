import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { RegistrationLoginService } from 'src/app/service/registration-login.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-otp-login',
  templateUrl: './otp-login.component.html',
  styleUrls: ['./otp-login.component.scss']
})
export class OtpLoginComponent implements OnInit {

  constructor(private fb: FormBuilder,
    public router: Router,
    public registrationLoginService: RegistrationLoginService,
    public _matSnackBar: MatSnackBar,
    private userService:UserService
) {
}
loginForm: FormGroup = this.fb.group({
    userEmail: ['', [Validators.required, Validators.email]],
});
otpForm: FormGroup = this.fb.group({
  otp: ['', [Validators.required]],
});

otp:any;
  ngOnInit(): void {
  }
user:any
  sendOTP(){
    this.registrationLoginService.sendOTP(this.loginForm.value).subscribe(
      (data)=>{
        this.otp=data;
        console.log(data);
        this._matSnackBar.open("OTP sent ! Check Email", "close", { duration: 2000, panelClass: ['snackBar-success'], horizontalPosition: 'center', verticalPosition: 'top' });
       
       
      },
      (error)=>{
        console.log(error);
       
      }
    )
  }

  validate(){
    if(this.otp==this.otpForm.controls['otp'].value){
     this.userService.getUser(this.loginForm.controls['userEmail'].value).subscribe(
      (data)=>{
        console.log(data);
        localStorage.setItem('currentUser' , JSON.stringify(this.user.userId));
        this.router.navigate(['']);
      },
      (error)=>{
        console.log(error);
        this._matSnackBar.open("First Time Login ..Please Register", "close", { duration: 2000, panelClass: ['snackBar-success'], horizontalPosition: 'center', verticalPosition: 'top' });
        this.router.navigate(['/registration']);
      }
     )
    }
  }
}
