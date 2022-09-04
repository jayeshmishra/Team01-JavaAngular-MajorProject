import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AllRestaurantsComponent } from './components/admin/all-restaurants/all-restaurants.component';
import { AllUsersComponent } from './components/admin/all-users/all-users.component';
import { DashHomeComponent } from './components/dashboard/dash-home/dash-home.component';
import { LoginComponent } from './components/dashboard/login/login.component';
import { RegistrationComponent } from './components/dashboard/registration/registration.component';
import { AddFoodItemsComponent } from './components/restaurant/add-food-items/add-food-items.component';
import { AddRestaurantComponent } from './components/restaurant/add-restaurant/add-restaurant.component';
import { RestaurantLoginComponent } from './components/restaurant/restaurant-login/restaurant-login.component';
import { RestaurantMenuComponent } from './components/restaurant/restaurant-menu/restaurant-menu.component';
import { RestaurantOwnerHomeComponent } from './components/restaurant/restaurant-owner-home/restaurant-owner-home.component';
import { UpdateRestaurantComponent } from './components/restaurant/update-restaurant/update-restaurant.component';
import { UserRestaurantMenuComponent } from './components/restaurant/user-restaurant-menu/user-restaurant-menu.component';
import { UserCartComponent } from './components/user/user-cart/user-cart.component';
import { UserOrdersComponent } from './components/user/user-orders/user-orders.component';
const routes: Routes = [
  {path:"", component:DashHomeComponent},
  {path:"login", component:LoginComponent},
  {path:"registration" , component:RegistrationComponent},
  {path:"getAllRestaurant" ,component:DashHomeComponent},
  {path:"restaurant-menu/:id/:name" , component:RestaurantMenuComponent},
  {path:"add-restaurant" , component:AddRestaurantComponent},
  {path:"add-food-item/:id" , component:AddFoodItemsComponent},
  {path:"admin-home" , component:AdminHomeComponent},
  {path:"restaurant-login" , component:RestaurantLoginComponent},
  {path:"restaurant-owner-home" , component:RestaurantOwnerHomeComponent},
  {path:"user-restaurant-menu/:id/:name" , component:UserRestaurantMenuComponent},
  {path:"get-all-user" , component:AllUsersComponent},
  {path:"get-all-restaurant" , component:AllRestaurantsComponent},
  {path:"update-restaurant/:id" , component:UpdateRestaurantComponent},
  {path:"user-cart/:id/:check/:restId" , component:UserCartComponent},
  {path:"user-orders/:userId/:cart/:amount/:restId" , component:UserOrdersComponent},
  {path:"user-cart" , component:UserCartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
