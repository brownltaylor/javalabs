import { Component, OnInit, Output } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { Customer } from 'src/app/model/Customer'; 
import { Address } from 'src/app/model/Address';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { EventEmitter } from 'events';
import { HttpClient } from 'selenium-webdriver/http';
@Component({
  selector: 'app-customer-signup',
  templateUrl: './customer-signup.component.html',
  styleUrls: ['./customer-signup.component.css']
})
export class CustomerSignupComponent implements OnInit {

  customer: Customer = {customer_id: 0, first_name: '', last_name: '', addresses: [{address_id:0, street_number: '', street_name: '', city: '', state:'', zip:''}]};
  sub: Subscription;
  
 

  constructor(
    private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute,

  ) { }


  ngOnInit() {

  }


  createCustomer() {
    return this.customerService.save(this.customer).subscribe( data => { 
      console.log('Saved!' + JSON.stringify(data));
      this.router.navigate(['/account-signup', this.customer.customer_id]);
    });
}
goToList() {
    return this.router.navigate(['/customer-list']);

  }


}
