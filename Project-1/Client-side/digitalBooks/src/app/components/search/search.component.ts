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
  items: string[] = ['hello','hi', '1', '2', '4', '4', '4', '4']

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
    this.SearchForm = this.formBuilder.group({
      title: [[]],
      category: [[]],
      price: [[]],
      author: [[]]
    });
  }

  //get all books based on filter
  searchBooks() {
    const promise = this.bookService.searchBooks(this.filter);
    promise.subscribe(
      (res) => {
        console.log(res);
        this.books = res as Book[];
      });
  }

}
