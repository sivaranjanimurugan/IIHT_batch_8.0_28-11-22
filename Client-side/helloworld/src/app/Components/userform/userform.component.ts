import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/user';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  title: String = "Please fill the form below"

  user: User = new User();

  save() {
    console.log("name " + this.user.firstname + " " + this.user.lastname);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
