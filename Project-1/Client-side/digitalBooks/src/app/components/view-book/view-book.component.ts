import { Component, OnInit } from '@angular/core';
import Book from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
  books: Book[] = [];

  constructor(
    private bookService: BookService) { }

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
      }
    )
    // window.location.reload();
    alert("Book deleted successfully !!");
  }

  //get all books
  getAllBooks() {
    const promise = this.bookService.getAllBooks();
    promise.subscribe(
      (res) => {
        console.log(res);
        this.books = res as Book[];
      });
  }

  //create new book
  blockBook(book: any, index: any, isActive: boolean) {
    const observable = this.bookService.blockBook(book, true);
    observable.subscribe(
      (res) => {
        console.log(res);
        this.books.splice(index, 1);
      }
    )
    // window.location.reload();
    alert("Book blocked successfully !!");
  }

  //sort book by price
  sortBooks() {
    this.books.sort((book1, book2) => {
      return book1.price - book2.price;
    })
  }

}
