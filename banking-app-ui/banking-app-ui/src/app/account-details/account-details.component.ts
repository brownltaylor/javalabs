import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from '../model/Message';
import { Bill } from '../model/Bill';
import { Withdrawal } from '../model/Withdrawal';
import { Deposit } from '../model/Deposit';
import { Account } from 'src/app/model/Account'; 

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {

 
  bills: Bill[]; 
  withdrawals: Withdrawal[];
  deposits: Deposit[];
  account: Account = {account_id: 0, type: '', nickname: '', rewards: 0, balance: 0, customer_id: 0}; 


  constructor(
    private accountService: AccountService, 
    private route: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit() {
    const accountId = this.route.snapshot.paramMap.get('id');
    const id = +accountId;
  
    this.accountService.findById(id).subscribe(data =>{ 
      data = <Message>data;
      this.account = <Account>data.data;
      console.log(this.account); 
    }); 

    this.accountService.getBills(id).subscribe(data => { 
      data = <Message>data; 
      this.bills = <Bill[]>data.data; 
      console.log(JSON.stringify(this.bills));
    });
    this.accountService.getWithdrawals(id).subscribe(data =>{ 
      data = <Message>data; 
      this.withdrawals = <Withdrawal[]>data.data; 
      console.log(JSON.stringify(this.withdrawals)); 
    });
    this.accountService.getDeposits(id).subscribe(data => { 
      data = <Message>data; 
      this.deposits = <Deposit[]>data.data; 
      console.log(JSON.stringify(this.deposits)); 
    });

  }
  
}
