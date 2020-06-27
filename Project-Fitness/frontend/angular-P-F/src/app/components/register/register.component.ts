import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import {FormsModule} from '@angular/forms';
import {RegisterService} from '../../services/register.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  userModel = new User("carlo", "asdf", 22, 70, 195);

  onSubmit(value: any) {
    console.log(value)
    this.registerService.insertUser(this.userModel)
    // .subscribe(
    //   data => console.log("success", data),
    //   error => console.error("error", error)
    // )
  }

  constructor(private registerService: RegisterService) { }

  ngOnInit(): void {
    // this.newUser();
  }

}
