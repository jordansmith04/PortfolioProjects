import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FutureWorkouts } from 'src/app/model/FutureWorkouts';
import { PastWorkouts } from 'src/app/model/PastWorkouts';

@Component({
  selector: 'app-future-workouts',
  templateUrl: './future-workouts.component.html',
  styleUrls: ['./future-workouts.component.css']
})
export class FutureWorkoutsComponent implements OnInit {

  futureWork: FutureWorkouts[] = [];
  constructor(private futureService: UserService) { }

  generatedWork = new PastWorkouts("admin", "pushups", 10)
  ngOnInit() {
  
  }


futureWorkouts(){
  this.futureService.getFutureWorkouts()
  .subscribe(
    (data) => {
    console.log("success", data),
    this.futureWork = data;
   },  (error) => {
     console.error("error", error)
   }
  )
}

pastWorkouts() {
  this.futureService.insertPastWorkout(this.generatedWork)
}
}
