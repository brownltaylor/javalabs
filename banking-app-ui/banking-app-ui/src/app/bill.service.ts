import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 

@Injectable({
  providedIn: 'root'
})
export class BillService {

  public API = 'http://localhost:8080/'

  constructor(
    private http: HttpClient
  ) { }

  save(account_id: number, bill: Object){ 
    return this.http.post(this.API + 'accounts/' + account_id + '/bills', bill);
  }

  findById(bill_id: number){ 
    return this.http.get(this.API + 'bill/' + bill_id); 
  }


  update(account_id: number, bill_id: number, value: any){ 
    return this.http.put(this.API + '/accounts/' + account_id + '/bills/' + bill_id, value); 
  }

  delete(bill_id: number){ 
    return this.http.delete(this.API + '/bills/' + bill_id);
    }
}
