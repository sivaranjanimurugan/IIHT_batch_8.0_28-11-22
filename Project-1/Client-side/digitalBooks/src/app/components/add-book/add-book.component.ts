import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Book from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  //Form Validables 
  bookForm: any = FormGroup;
  submitted = false;
  book: Book = new Book();

  constructor(private formBuilder: FormBuilder,
    private bookService: BookService
  ) { }

  ngOnInit(): void {
    //Add User form validations
    this.bookForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.pattern]],
      description: ['', [Validators.required, Validators.pattern]],
      category: ['', [Validators.required, Validators.pattern]],
      price: ['', [Validators.required, Validators.pattern]],
      author: ['', [Validators.required, Validators.pattern]],
      publisher: ['', [Validators.required, Validators.pattern]],
      publishedDate: ['', [Validators.required]],
      isActive: ['', [Validators.required]],
      contentType: ['', [Validators.required, Validators.pattern]],
      content: ['', [Validators.required, Validators.pattern]]
    });
  }

  //Add user form actions
  get f() { return this.bookForm.controls; }

  onSubmit() {
    console.log("hello");

    this.submitted = true;
    console.log(this.book);
    for (let el in this.bookForm.controls) {
      if (this.bookForm.controls[el].errors) {
        console.log(el)
      }
    }
    console.log(this.bookForm.invalid);
    // stop here if form is invalid
    if (this.bookForm.invalid) {
      return;
    }
    console.log("hi");
    //True if all the fields are filled
    if (this.submitted) {
      console.log("wel");
      this.createBook();
    }
  }

  //create new book
  createBook() {
    console.log(this.book);
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
