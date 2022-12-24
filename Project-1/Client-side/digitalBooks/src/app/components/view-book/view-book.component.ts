import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import Book from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ViewBookComponent implements OnInit {
  books: Book[] = [];

  constructor(
    private bookService: BookService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    //initalize when component starts
    this.getAllBooks();
  }

  deleteBook(book: any, index: any) {
    const observable = this.bookService.deleteBook(book);
    observable.subscribe(
      (res) => {
        console.log(res);
        this.books.splice(index, 1);
        this.successSnackBar("Book deleted successfully!");
      }, (err) => {
        this.errorSnackBar("Something went wrong !, Please try again");
        console.log(err);
      }
    )
  }

  //get all books
  getAllBooks() {
    const promise = this.bookService.getAllBooks();
    promise.subscribe(
      (res) => {
        // console.log(res);
        this.books = res as Book[];
        this.successSnackBar("Book loaded successfully!");
      }, (err) => {
        this.errorSnackBar("Something went wrong !, Please try again");
        console.log(err);
      }
    );
  }

  //block
  blockBook(book: any, index: any) {
    const observable = this.bookService.blockBook(book, false);
    observable.subscribe(
      (res) => {
        // console.log(res);
        this.books.splice(index, 1);
        this.successSnackBar("Book blocked successfully!");
      }, (err) => {
        this.errorSnackBar("Something went wrong !, Please try again");
        console.log(err);
      }
    )
  }

  //block
  unblockBook(book: any, index: any) {
    const observable = this.bookService.blockBook(book, true);
    observable.subscribe(
      (res) => {
        // console.log(res);
        this.books.splice(index, 1);
        this.successSnackBar("Book unblocked successfully!");
      }, (err) => {
        this.errorSnackBar("Something went wrong !, Please try again");
        console.log(err);
      }
    )
  }

  //sort book by price
  sortBooks() {
    this.books.sort((book1, book2) => {
      return book1.price - book2.price;
    })
    this.successSnackBar("Book sorted successfully!");
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
