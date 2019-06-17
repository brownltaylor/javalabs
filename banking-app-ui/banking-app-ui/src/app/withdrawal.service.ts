import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Withdrawal } from './model/Withdrawal';

@Injectable({
  providedIn: 'root'
})
export class WithdrawalService {

  public API = 'http://localhost:8080/';

  constructor(
    private http: HttpClient
  ) { }

  findById(withdrawal_id: number){ 
    return this.http.get(this.API + 'withdrawals/' + withdrawal_id);
  }

  save(account_id: number, withdrawal: Withdrawal){ 
    return this.http.post(this.API + '/accounts/' + account_id + '/withdrawals', withdrawal)
  }

  update(withdrawal_id: number, value: any){ 
    return this.http.put(this.API + 'withdrawals/' + withdrawal_id, value); 
  }

  delete(withdrawal_id: number){ 
    return this.http.delete(this.API + 'withdrawals/' + withdrawal_id); 
  }
}
