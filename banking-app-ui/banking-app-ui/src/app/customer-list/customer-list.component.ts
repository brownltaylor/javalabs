import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../model/Customer';
import { Message } from '../model/Message';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[];

  constructor(
    private customerService: CustomerService, 
    private route: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit() {
    this.customerService.findAll().subscribe(data =>{
      data = <Message>data;
      this.customers = <Customer[]>data.data;
      console.log(JSON.stringify(this.customers));
    });
  }

}
