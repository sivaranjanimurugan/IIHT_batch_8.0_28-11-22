import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  //Form Validables 
  bookForm: any = FormGroup;
  submitted = false;

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {

  }

}
