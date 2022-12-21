import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
   //Form Validables 
   loginForm:any = FormGroup;
   submitted = false;
   constructor( private formBuilder: FormBuilder){}
   //Add user form actions
   get f() { return this.loginForm.controls; }
   onSubmit() {
     
     this.submitted = true;
     // stop here if form is invalid
     if (this.loginForm.invalid) {
         return;
     }
     //True if all the fields are filled
     if(this.submitted)
     {
       alert("Great!!");
     }
    
   }
     ngOnInit() {
       //Add User form validations
       this.loginForm = this.formBuilder.group({
       email: ['', [Validators.required, Validators.email]],
       password: ['', [Validators.required]]
       });
     }
}
