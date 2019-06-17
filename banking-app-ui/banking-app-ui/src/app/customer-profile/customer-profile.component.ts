import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Customer } from '../model/Customer';
import { Message } from '../model/Message';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {

  accounts: Account[];
  message: Message;
  customer: Customer = {customer_id: 0, first_name: '', last_name: '', addresses: [{address_id:0, street_number: '', street_name: '', city: '', state:'', zip:''}]};
  constructor(
    private customerService: CustomerService, 
    private router: Router, 
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    const customer_id = this.route.snapshot.paramMap.get('customer_id');
    const id = +customer_id;
    this.customerService.findById(id).subscribe(data => { 
      data = <Message>data;
      this.customer = <Customer>data.data;
      
      console.log(this.customer);
    });
    this.customerService.getAccounts(id).subscribe(data =>{ 
      data = <Message>data;
      this.accounts = <Account[]>data.data;
      console.log(JSON.stringify(this.accounts));
  
    });
  }
 
}
