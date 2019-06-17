import { Component, OnInit } from '@angular/core';
import { Withdrawal } from 'src/app/model/Withdrawal';
import { WithdrawalService } from 'src/app/withdrawal.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs'; 
import { Message } from 'src/app/model/Message'; 

@Component({
  selector: 'app-create-withdrawal',
  templateUrl: './create-withdrawal.component.html',
  styleUrls: ['./create-withdrawal.component.css']
})
export class CreateWithdrawalComponent implements OnInit {

  withdrawal: Withdrawal = {withdrawal_id: 0, type: '', transaction_date: '', status: '', account_id: 0, medium: '', amount: 0, description: ''};
  sub: Subscription;
  
  constructor(
    private withdrawalService: WithdrawalService, 
    private route: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { 
      const id = params['id']; 
      if(id){
        this.withdrawalService.findById(id).subscribe(data => { 
          data = <Message>data; 
         const withdrawal = <Withdrawal>data.data;
         console.log(data);
          if (withdrawal) { 
            this.withdrawal = withdrawal; 
          } 
        });
      }
    });
  }

  createWithdrawal(){ 
    const accountId= this.route.snapshot.paramMap.get('id');
    const id = +accountId;
    console.log(id);
    this.withdrawalService.save(id, this.withdrawal).subscribe(result =>{
      console.log(JSON.stringify(result)); 
      this.router.navigate(['/account-details', id])
    });
  }
  goToDetails(){ 
    const accountId= this.route.snapshot.paramMap.get('id');
    const id = +accountId;
    this.router.navigate(['/account-details', id]);
  }

  deleteWithdrawal(){ 
    return this.withdrawalService.delete(this.withdrawal.withdrawal_id).subscribe(result =>{ 
      this.goToDetails();
    });
  }

}
