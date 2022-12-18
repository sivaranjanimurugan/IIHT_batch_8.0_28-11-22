import { Component, OnInit } from '@angular/core';
import Book from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
  }

  //create new book
  createBook() {
    const observables = this.bookService.createBook(this.book);
    observables.subscribe(
      (res: any) => {
        console.log(res);
      }, function (error) {
        console.log(error);
        alert("Something went wrong !, Please try again");
      }
    )
  }

}
