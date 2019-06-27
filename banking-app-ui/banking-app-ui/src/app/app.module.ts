import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CreateWithdrawalComponent } from './create-withdrawal/create-withdrawal.component';
import { CreateDepositComponent } from './create-deposit/create-deposit.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CustomerSignupComponent } from './customer-signup/customer-signup.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { CreateBillComponent } from './create-bill/create-bill.component';
import { CustomerService } from './customer.service';
import { AccountService } from './account.service';
import { WithdrawalService } from './withdrawal.service'; 
import { DepositService } from './deposit.service'; 
import { BillService } from './bill.service';
import { FormsModule } from '@angular/forms';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    CreateWithdrawalComponent,
    CreateDepositComponent,
    CreateAccountComponent,
    CustomerSignupComponent,
    CustomerProfileComponent,
    AccountDetailsComponent,
    CreateBillComponent,
    CustomerListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [CustomerService, AccountService, WithdrawalService, DepositService, BillService],
  bootstrap: [AppComponent]
})
export class AppModule { }
