import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Book, { BookFilter } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  //Form Validables 
  SearchForm: any = FormGroup;
  submitted = false;
  filter: BookFilter = new BookFilter();
  books: Book[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private bookService: BookService
  ) { }
  //Add user form actions
  get f() { return this.SearchForm.controls; }
  onSubmit() {

    this.submitted = true;
    // stop here if form is invalid
    if (this.SearchForm.invalid) {
      return;
    }
    //True if all the fields are filled
    if (this.submitted) {
      this.searchBooks();
    }

  }

  ngOnInit() {
    //Add User form validations
    // this.RegisterForm = this.formBuilder.group({
    //   username: ['', [Validators.required, Validators.pattern]],
    //   firstname: ['', [Validators.required, Validators.pattern]],
    //   lastname: ['', [Validators.required, Validators.pattern]],
    //   role: ['', [Validators.required, Validators.pattern]]
    // });
  }

  //get all books
  searchBooks() {
    const promise = this.bookService.searchBooks(this.filter);
    promise.subscribe(
      (res) => {
        console.log(res);
        this.books = res as Book[];
      });
  }

}
