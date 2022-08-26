import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegistrationLoginService } from 'src/app/service/registration-login.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  constructor(private fb:FormBuilder , private _registrationLoginService:RegistrationLoginService) { }

  ngOnInit(): void {
  }

  userForm:FormGroup=this.fb.group({       
    userName:[''],
    userPassword:[''],
    userEmail:[''],
    userMobileNo:['']
  })

  onSubmit(){
    // this.addAddress();
    console.log(this.userForm.value);
    this._registrationLoginService.registration(this.userForm.value).subscribe(data=>{
      console.log(data);
    });
    
  }
}