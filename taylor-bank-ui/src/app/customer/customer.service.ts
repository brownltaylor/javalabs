import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'; 
import { HttpClient } from '@angular/common/http'; 
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  public API = 'http://localhost:8080/api/customers';


  constructor(private http: HttpClient) { }

  getCustomer(id: number){ 
    return this.http.get(this.API + '/' + id); 
  }
  
  createCustomer(customer: Customer){ 
    return this.http.post(this.API + '/createCustomer', customer);
  }

  updateCustomer(id:number, value: any){ 
    return this.http.put(this.API + '/' + id, value);
  }







}
