import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs'; 
import { PersonService } from '../person.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from '../Person';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit, OnDestroy{

  person: Person = {id: 0, name: '', username: '', email: '', phone: '', website: '', address: {id: 0, street: '', suite: '', zipcode: '', city: '', geo: {id: 0, lat: 0, lng: 0}}, company: {id: 0, name: '', catchPhrase: '', bs: ''}}; 
  sub: Subscription;

  constructor(private route: ActivatedRoute,
    private router: Router, 
    private personService: PersonService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => { 
      const id = params['id']; 
      if(id){ 
        this.personService.get(id).subscribe((person: Person) => { 
          if (person) { 
            this.person = person;
            
    
             
          } else { 
            console.log(`Person with id '${id}' not found, returning to list`); 
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy(){ 
    this.sub.unsubscribe;
  }

  gotoList(){ 
    this.router.navigate(['/person-list']);
  }

save(){ 
  this.personService.save(this.person).subscribe(result => { 
    this.gotoList(); 
  }, error => console.error(error));
}

remove(){ 
  this.personService.delete(this.person.id).subscribe(result => { 
    this.gotoList(); 
  }, error => console.error(error)); 
  }
}
