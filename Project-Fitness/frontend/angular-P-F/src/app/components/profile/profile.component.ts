import { Component, OnInit, Input } from '@angular/core';
import {User} from '../../model/User'
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


 users: User[] = [];


 loginUsername: any[]=[];
  constructor(private userService :UserService) { }

  ngOnInit() {
    this.userService.loginUsername
    .subscribe(
     (username) =>{
       console.log(username);
       this.loginUsername.push(username);
       this.userService.getUser(username)
    .subscribe(
      (data) => {
      console.log(JSON.stringify(data)),
      console.log(this.users),
      (error) => {
       console.error("error", error)
     }
      }
    )
     },
     () => {
       console.log("There was an error grabbing your jokes!");
     }
 
    )
  
  }
  

}
