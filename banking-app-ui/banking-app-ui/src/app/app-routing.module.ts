import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { AppComponent } from './app.component';
import { CustomerSignupComponent } from './customer-signup/customer-signup.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { CreateWithdrawalComponent } from './create-withdrawal/create-withdrawal.component';
import { CreateDepositComponent } from './create-deposit/create-deposit.component';
import { CreateBillComponent } from './create-bill/create-bill.component';

const routes: Routes = [
 
  {path: 'customer/:customer_id', component: CustomerProfileComponent},
  {path: 'home', component: AppComponent}, 
  {path: 'signup', component: CustomerSignupComponent}, 
  {path: 'customer-edit/:id', component: CustomerSignupComponent},
  {path: 'account-signup/:id', component: CreateAccountComponent},
  {path: 'account-edit/:id', component: CreateAccountComponent},
  {path: 'profile/:customer_id', component: CustomerProfileComponent}, 
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'account-details/:id', component: AccountDetailsComponent}, 
  {path: 'create-withdrawal/:id', component: CreateWithdrawalComponent}, 
  {path: 'edit-withdrawal/:id', component: CreateWithdrawalComponent},
  {path: 'create-deposit/:id', component: CreateDepositComponent}, 
  {path: 'edit-deposit/:id', component: CreateDepositComponent},
  {path: 'create-bill/:id', component: CreateBillComponent}, 
  {path: 'edit-bill/:id', component: CreateBillComponent},
  {path: 'customers', component: CustomerListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
