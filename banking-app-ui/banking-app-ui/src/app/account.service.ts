import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  public API = 'http://localhost:8080/accounts';

  constructor(
    private http: HttpClient
  ) { }

  save(customer_id: number, account: Object){
    return this.http.post('http://localhost:8080/customers/' + customer_id + '/accounts' , account); 
  }

  update(account_id: number, value: any){
    return this.http.put(this.API + '/' + account_id, value)
  }

  findAll(){ 
    return this.http.get(this.API); 
  }

  findById(account_id: number){ 
    return this.http.get(this.API + '/' + account_id); 
  }

  getWithdrawals(account_id: number){ 
    return this.http.get(this.API + '/' + account_id + '/' + 'withdrawals'); 
  }
  
  getBills(account_id: number){
    return this.http.get(this.API + '/' + account_id + '/bills'); 
  }

  getDeposits(account_id: number){ 
    return this.http.get(this.API + '/' + account_id + '/deposits'); 
  }
  getCustomer(account_id: number){ 
    return this.http.get(this.API + '/' + account_id + '/customer'); 
  }

  delete(account_id){
    return this.http.delete(this.API + '/' + account_id); 
   }



}
