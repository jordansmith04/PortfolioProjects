import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'

import { AppRoutingModule, routingComponents} from './app-routing.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { WorkoutsComponent } from './components/workouts/workouts.component';
import { ChestArmsComponent } from './components/chest-arms/chest-arms.component';
import { LegsComponent } from './components/legs/legs.component';
import { BackShoulderComponent } from './components/back-shoulder/back-shoulder.component';
import { AbsComponent } from './components/abs/abs.component';
import { StretchComponent } from './components/stretch/stretch.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CommonModule } from '@angular/common';
import { FutureWorkoutsComponent } from './components/future-workouts/future-workouts.component';
import { PastWorkoutsComponent } from './components/past-workouts/past-workouts.component';



@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    WorkoutsComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule
    
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
