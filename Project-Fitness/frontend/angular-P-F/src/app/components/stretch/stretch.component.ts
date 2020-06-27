import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FutureWorkouts } from 'src/app/model/FutureWorkouts';

@Component({
  selector: 'app-stretch',
  templateUrl: './stretch.component.html',
  styleUrls: ['./stretch.component.css']
})
export class StretchComponent implements OnInit {

  constructor(private stretchService: UserService) { }
  generatedWork = new FutureWorkouts("admin", "shoulder stretch", 20)
  generatedWork2 = new FutureWorkouts("admin", "chest stretch", 20)
  generatedWork3 = new FutureWorkouts("admin", "calf stretch", 20)
  ngOnInit(): void {
  }
  addStretch(){
    this.stretchService.insertFutureWorkout(this.generatedWork)
    this.stretchService.insertFutureWorkout(this.generatedWork2)
    this.stretchService.insertFutureWorkout(this.generatedWork3)
  }
}
