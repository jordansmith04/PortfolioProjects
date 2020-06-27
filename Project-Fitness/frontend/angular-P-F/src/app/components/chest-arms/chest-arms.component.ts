import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FutureWorkouts } from 'src/app/model/FutureWorkouts';

@Component({
  selector: 'app-chest-arms',
  templateUrl: './chest-arms.component.html',
  styleUrls: ['./chest-arms.component.css']
})
export class ChestArmsComponent implements OnInit {

  generatedWork = new FutureWorkouts("admin", "pushups", 10)
  
  constructor(private chestArmService: UserService) { }

  ngOnInit(): void {
  }

  addChestArm(){
    this.chestArmService.insertFutureWorkout(this.generatedWork)
  }

}
