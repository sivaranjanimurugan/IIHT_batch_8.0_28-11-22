import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import Book, { BookFilter, SubscribeDetails } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class SearchComponent implements OnInit {

  //Form Validables 
  SearchForm: any = FormGroup;
  submitted = false;
  filter: BookFilter = new BookFilter();
  books: Book[] = [];
  subDetails: SubscribeDetails = new SubscribeDetails();
  enable: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private bookService: BookService,
    private snackBar: MatSnackBar,
    private tokenService: TokenStorageService
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
    if (this.tokenService.getUser().role === 'READER' || this.tokenService.getUser().role === 'AUTHOR') {
      this.enable = true;
    }

    //Add User form validations
    this.SearchForm = this.formBuilder.group({
      title: [[]],
      category: [[]],
      price: [[]],
      author: [[]]
    });
    //onloading
    this.searchBooks();
  }

  //get all books based on filter
  searchBooks() {
    // console.log(this.filter);
    const promise = this.bookService.searchBooks(this.filter);
    promise.subscribe(
      (res) => {
        console.log(res);
        this.books = res as Book[];
        this.successSnackBar("Book loaded successfully!");
      }, (err) => {
        this.errorSnackBar("Something went wrong !, Please try again");
        console.log(err);
      }
    );
  }

  //subscribe book
  subscribeBook(book: any) {
    this.subDetails.subName = this.tokenService.getUser().username;
    this.subDetails.subRole = this.tokenService.getUser().role;
    this.subDetails.isSubscribed = true;
    const observable = this.bookService.subscribeBook(book, this.subDetails);
    observable.subscribe(
      (res) => {
        let body = JSON.parse(JSON.stringify(res)).body;
        // console.log(body);
        this.successSnackBar("Book subscribed successfully! subscription_Id is " + body);
      }, (err) => {
        this.errorSnackBar("Something went wrong !, Please try again");
        console.log(err);
      }
    )
  }

  successSnackBar(message: string) {
    this.snackBar.open(message, 'X', {
      duration: 5000, panelClass: 'snackbar-success'
    });
  }

  errorSnackBar(message: string) {
    this.snackBar.open(message, 'X', {
      duration: 5000, panelClass: 'snackbar-error'
    });
  }

}
