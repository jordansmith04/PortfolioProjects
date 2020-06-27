import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FutureWorkouts } from 'src/app/model/FutureWorkouts';

@Component({
  selector: 'app-back-shoulder',
  templateUrl: './back-shoulder.component.html',
  styleUrls: ['./back-shoulder.component.css']
})
export class BackShoulderComponent implements OnInit {

  constructor(private backShoulderService: UserService) { }

  generatedWork = new FutureWorkouts("admin", "superman", 20)
  generatedWork2 = new FutureWorkouts("admin", "shoulder taps", 50)
  generatedWork3 = new FutureWorkouts("admin", "mountain climbers", 50)

  ngOnInit(): void {
  }

  addBackShoulder(){
    this.backShoulderService.insertFutureWorkout(this.generatedWork)
    this.backShoulderService.insertFutureWorkout(this.generatedWork2)
    this.backShoulderService.insertFutureWorkout(this.generatedWork3)
  }
}
