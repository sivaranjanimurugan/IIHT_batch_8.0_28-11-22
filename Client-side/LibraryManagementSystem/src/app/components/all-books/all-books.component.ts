import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Book from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-all-books',
  templateUrl: './all-books.component.html',
  styleUrls: ['./all-books.component.css']
})
export class AllBooksComponent implements OnInit {

  books: Book[] = [];

  constructor(private router: Router,
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

  //sort book by price
  sortBooks() {
    this.books.sort((book1, book2) => {
      return book1.price - book2.price;
    })
  }

}
