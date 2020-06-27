import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FutureWorkouts } from 'src/app/model/FutureWorkouts';

@Component({
  selector: 'app-abs',
  templateUrl: './abs.component.html',
  styleUrls: ['./abs.component.css']
})
export class AbsComponent implements OnInit {

  constructor(private absService: UserService) { }

  generatedWork = new FutureWorkouts("admin", "sit-ups", 20)
  generatedWork2 = new FutureWorkouts("admin", "crunches", 20)
  generatedWork3 = new FutureWorkouts("admin", "leg raises", 20)

  ngOnInit(): void {
  }
  addAbs(){
    this.absService.insertFutureWorkout(this.generatedWork)
    this.absService.insertFutureWorkout(this.generatedWork2)
    this.absService.insertFutureWorkout(this.generatedWork3)
  }
}
