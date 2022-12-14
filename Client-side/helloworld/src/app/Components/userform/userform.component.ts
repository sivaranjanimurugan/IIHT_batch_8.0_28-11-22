import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  title: String = "Please fill the form below"

  firstname: String = '';
  lastname: String = '';
  age: number = 0;
  gender: String = 'female';
  email: String = '';

  save() {
    console.log("name " + this.firstname + " " + this.lastname);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
