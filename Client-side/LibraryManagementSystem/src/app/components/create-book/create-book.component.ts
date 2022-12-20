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

  nameMatch = new RegExp('[A-Za-z ]{3,32}');
  numberMatch = new RegExp('[0-9]{1,2}');

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
  }

  //create new book
  createBook() {
    const observables = this.bookService.createBook(this.book);
    observables.subscribe(
      (res: any) => {
        console.log(res);
        // alert("Inserted Successfully !!");
      }, function (error) {
        console.log(error);
        alert("Something went wrong !, Please try again");
      }
    )
  }

  // validate form
  checkValid() {
    if (this.book.bookName === '' || (!this.nameMatch.test(this.book.bookName))
      || this.book.authorName === '' || (!this.nameMatch.test(this.book.authorName))
      || this.book.genre === '' || (!this.nameMatch.test(this.book.genre))
    ) {
      return false;
    } else {
      return true;
    }
  }

}
