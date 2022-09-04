import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AllRestaurantsComponent } from './components/admin/all-restaurants/all-restaurants.component';
import { AllUsersComponent } from './components/admin/all-users/all-users.component';
import { GenerateReportsComponent } from './components/admin/generate-reports/generate-reports.component';
import { DashHomeComponent } from './components/dashboard/dash-home/dash-home.component';
import { LoginComponent } from './components/dashboard/login/login.component';
import { RegistrationComponent } from './components/dashboard/registration/registration.component';
import { AddFoodItemsComponent } from './components/restaurant/add-food-items/add-food-items.component';
import { AddRestaurantComponent } from './components/restaurant/add-restaurant/add-restaurant.component';
import { OrdersComponent } from './components/restaurant/orders/orders.component';
import { RestaurantLoginComponent } from './components/restaurant/restaurant-login/restaurant-login.component';
import { RestaurantMenuComponent } from './components/restaurant/restaurant-menu/restaurant-menu.component';
import { RestaurantOwnerHomeComponent } from './components/restaurant/restaurant-owner-home/restaurant-owner-home.component';
import { UpdateFoodItemsComponent } from './components/restaurant/update-food-items/update-food-items.component';
import { UpdateRestaurantComponent } from './components/restaurant/update-restaurant/update-restaurant.component';
import { UserRestaurantMenuComponent } from './components/restaurant/user-restaurant-menu/user-restaurant-menu.component';
import { OtpLoginComponent } from './components/user/otp-login/otp-login.component';
import { UserCartComponent } from './components/user/user-cart/user-cart.component';
import { UserOrdersComponent } from './components/user/user-orders/user-orders.component';
import { UserProfileComponent } from './components/user/user-profile/user-profile.component';
import { MaterialModule } from './material/material.module';
import { AboutUsComponent } from './components/about-us/about-us.component';

@NgModule({
  declarations: [
    AppComponent,
    DashHomeComponent,
    LoginComponent,
    RegistrationComponent,
    RestaurantMenuComponent,
    AddRestaurantComponent,
    AdminHomeComponent,
    RestaurantOwnerHomeComponent,
    AllUsersComponent,
    AllRestaurantsComponent,
    AddFoodItemsComponent,
    OtpLoginComponent,
    UserProfileComponent,
    UserCartComponent,
    UserOrdersComponent,
    UpdateRestaurantComponent,
    GenerateReportsComponent,
    UpdateFoodItemsComponent,
    OrdersComponent,
    RestaurantLoginComponent,
    UserRestaurantMenuComponent,
    AboutUsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FlexLayoutModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
