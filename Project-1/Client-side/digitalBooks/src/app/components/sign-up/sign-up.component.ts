import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import User from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  //Form Validables 
  RegisterForm: any = FormGroup;
  submitted = false;
  user: User = new User();

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService) { }
  //Add user form actions
  get f() { return this.RegisterForm.controls; }
  onSubmit() {

    this.submitted = true;
    // stop here if form is invalid
    if (this.RegisterForm.invalid) {
      return;
    }
    //True if all the fields are filled
    if (this.submitted) {
      this.createUser();
    }

  }

  ngOnInit() {
    //Add User form validations
    this.RegisterForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.pattern]],
      firstname: ['', [Validators.required, Validators.pattern]],
      lastname: ['', [Validators.required, Validators.pattern]],
      role: ['', [Validators.required, Validators.pattern]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  //create new user
  createUser() {
    const observables = this.userService.createUser(this.user);
    observables.subscribe(
      (res: any) => {
        console.log(res);
      }, function (error) {
        console.log(error);
        alert("Something went wrong !, Please try again");
      }
    )
  }
}
