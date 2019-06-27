import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { Customer } from '../../model/customer'; 
import { Subscription } from 'rxjs';
import { Address } from 'src/app/model/address';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})



export class CustomerEditComponent implements OnInit{

  customer: Customer = {id: 0, first_name: '', last_name: '', username: '', password: ''};
  sub: Subscription; 
  

  constructor(
    private router: Router,
    private route: ActivatedRoute, 
    private customerService: CustomerService
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

  goToProfile(id: number){
    this.router.navigate(['/customer-profile/' + id])
  }

 
register(){ 
  return this.customerService.createCustomer(this.customer).subscribe(result => {
    this.goToProfile(this.customer.id);
  }, error => console.error(error)); 
}




}
