import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NavigationExtras, Router } from '@angular/router';
import { RegistrationLoginService } from 'src/app/service/registration-login.service';
import { IUser } from 'src/app/utility/IUser';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
    constructor(private fb: FormBuilder,
        public router: Router,
        public registrationLoginService: RegistrationLoginService,
        public _matSnackBar: MatSnackBar,
    ) {
    }
    loginForm: FormGroup = this.fb.group({
        userEmail: ['', [Validators.required, Validators.email]],
        userPassword: ['', [Validators.required, Validators.minLength(5)]]
    });
    errorMessage: string = ''
    statusCode: any;
    user: IUser = { userId: 0, userName: '', userEmail: '', userPassword: '', userMobileNo: '', attemptCount: 0 };
    login() {
        console.log(this.loginForm.contains.length);
        if(this.loginForm.controls['userEmail'].value=="admin@cybage.com" && this.loginForm.controls['userPassword'].value=="admin" ){
            const navigationExtras: NavigationExtras = {
                queryParamsHandling: 'preserve',
                preserveFragment: true
            };
            this.router.navigate(["/admin-home"], navigationExtras);
        }else{
        this.registrationLoginService.login(this.loginForm.value).subscribe(
            data => {
                this.user = data;
                this._matSnackBar.open(this.user.userName, "close", { duration: 2000, panelClass: ['snackBar-success'], horizontalPosition: 'center', verticalPosition: 'top' });
                const redirectUrl = '';
                console.log(this.user);
                localStorage.setItem('currentUser' , JSON.stringify(this.user.userId));
                const navigationExtras: NavigationExtras = {
                    queryParamsHandling: 'preserve',
                    preserveFragment: true
                };
                this.router.navigate([redirectUrl], navigationExtras);

            },
            error => {
                this.statusCode = error.status;
                this.errorMessage = error.error;
                console.log(error.status);
                console.log(error.error)
                if (this.statusCode == 400) {
                    this._matSnackBar.open(this.errorMessage, "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });
                } else if (this.statusCode == 404) {
                    this._matSnackBar.open(this.errorMessage, "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });
                } else if (this.statusCode == 423) {
                    this._matSnackBar.open(this.errorMessage, "close", { duration: 2000, panelClass: ['snackBar-error'], horizontalPosition: 'center', verticalPosition: 'top' });
                }
            });
        }
    }
    ngOnInit(): void {
        // TODO document why this method 'ngOnInit' is empty
    }

}
