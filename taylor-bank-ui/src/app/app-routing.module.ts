import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { AppComponent } from './app.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'}, 
  {path: 'sign-up', component: CustomerEditComponent},
  {path: 'customer-profile/:id', component: CustomerProfileComponent},
  {path: 'home', component: AppComponent},
  {path: 'customer-profile/:id', component: CustomerProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
