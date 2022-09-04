import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NavigationExtras, Router } from '@angular/router';
import { RegistrationLoginService } from 'src/app/service/registration-login.service';
import { IRestaurantLogin } from 'src/app/utility/IRestaurantLogin';

@Component({
  selector: 'app-restaurant-login',
  templateUrl: './restaurant-login.component.html',
  styleUrls: ['./restaurant-login.component.scss']
})
export class RestaurantLoginComponent implements OnInit {
  constructor(private fb: FormBuilder,
    public router: Router,
    public registrationLoginService: RegistrationLoginService,
    public _matSnackBar: MatSnackBar
) {
}
restaurantOwnerForm: FormGroup = this.fb.group({
    restaurantEmail: ['', [Validators.required, Validators.email]],
    restaurantPassword: ['', [Validators.required, Validators.minLength(5)]]
});
errorMessage: string = ''
statusCode: any;
restaurantOwner: any = { restaurantEmail:'' , restaurantPassword:''};
restaurantLogin() {
    this.registrationLoginService.restaurantLogin(this.restaurantOwnerForm.value).subscribe(
        data => {
            this.restaurantOwner = data;
            console.log(this.restaurantOwner)
            this._matSnackBar.open(this.restaurantOwner.restaurantEmail, "close", { duration: 2000, panelClass: ['snackBar-success'], horizontalPosition: 'center', verticalPosition: 'top' });
            this.router.navigate(['/restaurant-menu', this.restaurantOwner.restaurantId , this.restaurantOwner.restaurantName])
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
          this.router.navigate(['/restaurant-login'])
        });
      }
ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
}
}

