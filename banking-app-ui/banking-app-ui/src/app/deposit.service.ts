import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 

@Injectable({
  providedIn: 'root'
})
export class DepositService {

  public API = 'http://localhost:8080/';

  constructor(
    private http: HttpClient
  ) { }

  save(account_id: number, account: Object){ 
    return this.http.post(this.API + '/accounts/' + account_id + '/deposits', account); 
  }

  findById(deposit_id: number){ 
    return this.http.get(this.API + '/deposits/' + deposit_id); 
  }

  update(deposit_id: number, value: any){ 
    return this.http.put(this.API + '/deposits/' + deposit_id, value); 
  }

  delete(deposit_id: number){ 
    return this.http.delete(this.API + '/deposits/' + deposit_id); 
  }
}
