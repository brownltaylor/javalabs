import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { AccountEditComponent } from './account/account-edit/account-edit.component';
import { CreateDepositComponent } from './deposit/create-deposit/create-deposit.component';
import { CreateWithdrawlComponent } from './withdrawl/create-withdrawl/create-withdrawl.component';
import { CreateBillComponent } from './bill/create-bill/create-bill.component';
import { HttpClientModule } from '@angular/common/http'; 
import { CustomerService } from './customer/customer.service';
import { AccountService } from './account/account.service';
import { WithdrawlService } from './withdrawl/withdrawl.service';
import { DepositService } from './deposit/deposit.service';
import { BillService } from './bill/bill.service';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component'; 

@NgModule({
  declarations: [
    AppComponent,
    CustomerEditComponent,
    AccountEditComponent,
    CreateDepositComponent,
    CreateWithdrawlComponent,
    CreateBillComponent,
    HomeComponent,
    CustomerProfileComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule, 
    BrowserAnimationsModule,
    MatButtonModule, 
    MatInputModule, 
    MatCardModule, 
    MatListModule, 
    MatToolbarModule,
    FormsModule
  ],
  providers: [
    CustomerService, 
    AccountService, 
    WithdrawlService, 
    DepositService, 
    BillService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
