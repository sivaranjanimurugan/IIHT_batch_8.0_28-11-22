import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import Book, { SubscribeDetails } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-subscribed-book',
  templateUrl: './subscribed-book.component.html',
  styleUrls: ['./subscribed-book.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class SubscribedBookComponent implements OnInit {
  books: Book[] = [];
  subDetails: SubscribeDetails = new SubscribeDetails();

  constructor(
    private bookService: BookService,
    private tokenService: TokenStorageService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.subscribedBooks();
  }

  //get all subscribed books
  subscribedBooks() {
    // console.log(this.filter);
    const promise = this.bookService.subscribedBooks(this.tokenService.getUser().username);
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
  unsubscribeBook(book: any, index: any) {
    this.subDetails.subName = this.tokenService.getUser().username;
    this.subDetails.subRole = this.tokenService.getUser().role;
    this.subDetails.isSubscribed = false;
    const observable = this.bookService.unsubscribeBook(book, this.subDetails);
    observable.subscribe(
      (res) => {
        this.books.splice(index, 1);
        this.successSnackBar("Book unsubscribed successfully!");
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
