import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Customer } from 'src/app/model/Customer'; 
import { Observable } from 'rxjs'; 
import { Message } from './model/Message';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  public API = 'http://localhost:8080/customers';

  constructor(
    private http: HttpClient
  ) { }

findAll(){ 
  return this.http.get(this.API); 
}

findById(customer_id: number){ 
  return this.http.get(this.API + '/' + customer_id); 
}

save(customer: Customer){ 
return this.http.post<Customer>(this.API, customer);

}


update(customer_id: number, value: any){ 
  return this.http.put(this.API + '/' + customer_id, value);
}

getBills(customer_id: number){ 
  return this.http.get(this.API + '/' + customer_id + '/bills'); 
}

getAccounts(customer_id: number){ 
  return this.http.get(this.API + '/' + customer_id + '/accounts'); 
}
}
