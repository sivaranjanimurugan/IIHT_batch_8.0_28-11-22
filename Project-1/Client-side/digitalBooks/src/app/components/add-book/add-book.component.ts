import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  //Form Validables 
  bookForm: any = FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    //Add User form validations
    this.bookForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.pattern]],
      firstname: ['', [Validators.required, Validators.pattern]],
      lastname: ['', [Validators.required, Validators.pattern]],
      role: ['', [Validators.required, Validators.pattern]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  //Add user form actions
  get f() { return this.bookForm.controls; }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.bookForm.invalid) {
      return;
    }
  }

}
