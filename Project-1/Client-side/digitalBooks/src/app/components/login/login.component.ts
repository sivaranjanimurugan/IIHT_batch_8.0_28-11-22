import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtRequest } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  //Form Validables 
  loginForm: any = FormGroup;
  submitted = false;
  request: JwtRequest = new JwtRequest();

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService) { }
  //Add user form actions
  get f() { return this.loginForm.controls; }
  onSubmit() {

    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    //True if all the fields are filled
    if (this.submitted) {
      this.login();
    }

  }

  ngOnInit() {
    //Add User form validations
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.pattern]],
      password: ['', [Validators.required]]
    });
  }

  //login user
  login() {
    const observables = this.userService.login(this.request);
    observables.subscribe(
      (res: any) => {
        // console.log(res['jwtToken']);
        localStorage.setItem("token", res['jwtToken']);
      }, function (error) {
        console.log(error);
        alert("Something went wrong !, Please try again");
      }
    )
  }

}
