import { Component, OnInit } from '@angular/core';
import { BillService } from '../bill.service';
import { WithdrawalService } from '../withdrawal.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Bill } from '../model/Bill';
import { Subscription } from 'rxjs';
import { Message } from '../model/Message';


@Component({
  selector: 'app-create-bill',
  templateUrl: './create-bill.component.html',
  styleUrls: ['./create-bill.component.css']
})
export class CreateBillComponent implements OnInit {

  bill:Bill = {bill_id: 0, status: '', nickname: '', payee: '', creation_date: '', recurring_date: '', payment_amount: 0, payment_date: '', upcoming_payment_date: '', account_id: 0 };
  sub: Subscription;
  constructor(
    private billService: BillService, 
    private route: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { 
      const id = params['id']; 
      if(id){
        this.billService.findById(id).subscribe(data => { 
          data = <Message>data; 
         const bill = <Bill>data.data;
         console.log(data);
          if (bill) { 
            this.bill = bill; 
          } 
        });
      }
    });
  }
  createBill(){ 
    const accountId= this.route.snapshot.paramMap.get('id');
    const id = +accountId;
    console.log(id);
    this.billService.save(id, this.bill).subscribe(result =>{
      console.log(JSON.stringify(result)); 
      this.router.navigate(['/account-details', id])
    });

  }
  deleteBill(){ 
    return this.billService.delete(this.bill.bill_id).subscribe(result =>{ 
      this.goToDetails();
    });
  }

  goToDetails(){ 
    const accountId= this.route.snapshot.paramMap.get('id');
    const id = +accountId;
    this.router.navigate(['/account-details', id]);
  }

  
}
