import { Component, OnInit } from '@angular/core';
import { DepositService } from '../deposit.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Deposit } from '../model/Deposit';
import { Subscription } from 'rxjs';
import { Message } from '../model/Message';

@Component({
  selector: 'app-create-deposit',
  templateUrl: './create-deposit.component.html',
  styleUrls: ['./create-deposit.component.css']
})
export class CreateDepositComponent implements OnInit {

  
  
  deposit: Deposit = {deposit_id: 0, type: '', transaction_date: '', status: '', account_id: 0, medium: '', amount: 0, description: ''};
  sub: Subscription;

  constructor(
    private depositService: DepositService, 
    private router: Router, 
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { 
      const id = params['id']; 
      if(id){
        this.depositService.findById(id).subscribe(data => { 
          data = <Message>data; 
         const deposit = <Deposit>data.data;
         console.log(data);
          if (deposit) { 
            this.deposit = deposit; 
          } 
        });
    };
  });
  }

  createDeposit(){ 
    const accountId= this.route.snapshot.paramMap.get('id');
    const id = +accountId;
    console.log(id);
    this.depositService.save(id, this.deposit).subscribe(result =>{
      console.log(JSON.stringify(result)); 
      this.router.navigate(['/account-details', id])
    });
  }
  goToDetails(){ 
    const accountId= this.route.snapshot.paramMap.get('id');
    const id = +accountId;
    this.router.navigate(['/account-details', id]);
  }

  deleteDeposit(){ 
    return this.depositService.delete(this.deposit.deposit_id).subscribe(result =>{ 
      this.goToDetails();
    });
  }
}
