import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { WorkoutsComponent } from './components/workouts/workouts.component';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ChestArmsComponent } from './components/chest-arms/chest-arms.component';
import { LegsComponent } from './components/legs/legs.component';
import { BackShoulderComponent } from './components/back-shoulder/back-shoulder.component';
import { AbsComponent } from './components/abs/abs.component';
import { StretchComponent } from './components/stretch/stretch.component';
import { ProfileComponent } from './components/profile/profile.component';
import { FutureWorkoutsComponent } from './components/future-workouts/future-workouts.component';
import { PastWorkoutsComponent } from './components/past-workouts/past-workouts.component';


const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'register', component: RegisterComponent},
  {path: '', component: WorkoutsComponent},
  {path: '', component: NavbarComponent, outlet:"navbar"},
  {path:'chestArms', component: ChestArmsComponent},
  {path:'legs', component: LegsComponent},
  {path:'backShoulder', component: BackShoulderComponent},
  {path:'Abs', component: AbsComponent},
  {path:'stretches', component: StretchComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'futureWorkouts', component: FutureWorkoutsComponent},
  {path: 'pastWorkouts', component: PastWorkoutsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule],
  exports: [RouterModule, FormsModule]
})
export class AppRoutingModule { }

export const routingComponents = [LoginComponent, RegisterComponent, WorkoutsComponent, NavbarComponent,
   ChestArmsComponent, LegsComponent, BackShoulderComponent, AbsComponent, StretchComponent, ProfileComponent,
  FutureWorkoutsComponent, PastWorkoutsComponent]