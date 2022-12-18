import { Component, OnInit } from '@angular/core';
import Book from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-all-books',
  templateUrl: './all-books.component.html',
  styleUrls: ['./all-books.component.css']
})
export class AllBooksComponent implements OnInit {

  books: Book[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    //initalize when component starts
    const promise = this.bookService.getAllBooks();
    promise.subscribe(
      (res) => {
        console.log(res);
        this.books = res as Book[];
      });
  }

  deleteBook(book: any, index: any) {
    const observable = this.bookService.deleteBook(book);
    observable.subscribe(
      (res) => {
        console.log(res);
        this.books.splice(index, 1);
      }
    )
  }

}
