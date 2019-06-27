import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'; 
import { Observable } from 'rxjs';
import { PersonListComponent } from 'src/app/person-list/person-list.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { FormsModule } from '@angular/forms';  
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 
import { PersonService } from './person.service';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';


@NgModule({
  declarations: [
    AppComponent,
    PersonListComponent,
    PersonFormComponent,
    CustomerProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule, 
    MatButtonModule, 
    MatInputModule, 
    MatCardModule, 
    MatListModule, 
    MatToolbarModule,
    FormsModule
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
