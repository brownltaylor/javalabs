import { Component, OnInit } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';
import { CustomerService } from '../customer/customer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {

  customer: Customer;

  sub:Subscription

  constructor(
    private customerService: CustomerService, 
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { 
      const id = params['id']; 
      if(id){ 
        this.customerService.getCustomer(id).subscribe((customer: Customer) => { 
          if (customer) { 
            this.customer = customer; 
          } else { 
            console.log(`Person with id '${id}' not found, returning to list`); 
            this.goToHome();
          }
        });
      }
    });
    
    
  }

  goToHome(){ 
    this.router.navigate(['/home']);
  }

}
