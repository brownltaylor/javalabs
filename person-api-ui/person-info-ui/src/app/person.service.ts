import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { Observable } from 'rxjs'; 
import { Person } from './person';
import { NgForm } from '@angular/forms';
@Injectable({
  providedIn: 'root'
})
export class PersonService {
  
  
  public PERSON_API = 'http://localhost:8080/api/people'; 

  
  
  
  

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> { 
    return this.http.get(this.PERSON_API); 
  }
  
  get(id: number){ 
    return this.http.get(this.PERSON_API + '/' + id); 
  }

  save(person: Object): Observable<Object>{ 
    return this.http.post(this.PERSON_API + '/createRecord', person);
     
  }

  update(id: number, value: any): Observable<Object>{ 
    return this.http.put(this.PERSON_API + '/' + id, value); 
  }

  delete(id: number): Observable<any>{ 
     
    return this.http.delete(this.PERSON_API + '/' + id, {responseType: 'text'});
  }



}