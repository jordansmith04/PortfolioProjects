import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { PastWorkouts} from '../../model/PastWorkouts'

@Component({
  selector: 'app-past-workouts',
  templateUrl: './past-workouts.component.html',
  styleUrls: ['./past-workouts.component.css']
})
export class PastWorkoutsComponent implements OnInit {

  constructor(private pastService: UserService) { }
  pastWork: PastWorkouts[] = [];
  ngOnInit(): void {
  }
  pastWorkouts(){
    this.pastService.getPastWorkouts()
    .subscribe(
      (data) => {
      console.log("success", data),
      this.pastWork = data;
     },  (error) => {
       console.error("error", error)
     }
    )
  }
}
