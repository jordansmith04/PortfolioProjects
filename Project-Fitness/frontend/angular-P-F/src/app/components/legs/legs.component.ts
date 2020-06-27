import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FutureWorkouts } from 'src/app/model/FutureWorkouts';

@Component({
  selector: 'app-legs',
  templateUrl: './legs.component.html',
  styleUrls: ['./legs.component.css']
})
export class LegsComponent implements OnInit {

  constructor(private legService: UserService) { }

  generatedWork = new FutureWorkouts("admin", "squats", 25)
  generatedWork2 = new FutureWorkouts("admin", "High Knees", 125)
  generatedWork3 = new FutureWorkouts("admin", "Calf Raises", 100)

  ngOnInit(): void {
  }


  addLeg(){
    this.legService.insertFutureWorkout(this.generatedWork)
    this.legService.insertFutureWorkout(this.generatedWork2)
    this.legService.insertFutureWorkout(this.generatedWork3)
  }
}
