import { Component, OnInit, Input } from '@angular/core';
import { Subscription } from 'rxjs'; 
import { Customer } from 'src/app/model/Customer'; 
import { Account } from 'src/app/model/Account'; 
import { AccountService } from 'src/app/account.service'; 
import { CustomerService } from 'src/app/customer.service';
import { Router, ActivatedRoute } from '@angular/router'; 
import { Message } from '../model/Message';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  sub:Subscription;
  @Input() customer: Customer;
  account: Account = {account_id: 0, type: '', nickname: '', rewards: 0, balance: 0, customer_id: 0};

  constructor(
    private customerService: CustomerService, 
    private accountService: AccountService,
    private router: Router, 
    private route: ActivatedRoute

  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { 
      const id = params['id']; 
      if(id){
        this.accountService.findById(id).subscribe(data => { 
          data = <Message>data; 
         const account = <Account>data.data;
         console.log(data);
          if (account) { 
            this.account = account; 
          } 
        });
      }
    });
  }

  createAccount(){ 
    const customerId = this.route.snapshot.paramMap.get('id');
    const id = +customerId;
    console.log(id);
    this.accountService.save(id, this.account).subscribe(result =>{
      console.log(JSON.stringify(result)); 
      this.router.navigate(['/profile', id])
    });

  }

  deleteAccount(){ 
    return this.accountService.delete(this.account.account_id).subscribe(result =>{ 
      this.goToProfile();
    });
  }

  goToProfile(){ 
    const customerId = this.route.snapshot.paramMap.get('id');
    const id = +customerId;
    this.router.navigate(['/profile', id])
    
  }

  

  goToHome() {
    return this.router.navigate['/home'];

  }


}
