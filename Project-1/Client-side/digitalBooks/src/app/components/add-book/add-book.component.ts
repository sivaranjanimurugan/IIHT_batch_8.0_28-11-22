import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import Book, { BookContent } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AddBookComponent implements OnInit {
  //Form Validables 
  bookForm: any = FormGroup;
  submitted = false;
  book: Book = new Book();
  bookContent: BookContent = new BookContent();
  BookContentList: BookContent[] = [];
  file: any;

  constructor(private formBuilder: FormBuilder,
    private bookService: BookService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    //Add User form validations
    this.bookForm = this.formBuilder.group({
      // title: ['', [Validators.required, Validators.pattern]],
      // description: ['', [Validators.required, Validators.pattern]],
      // category: ['', [Validators.required, Validators.pattern]],
      // price: ['', [Validators.required, Validators.pattern]],
      // author: ['', [Validators.required, Validators.pattern]],
      // publisher: ['', [Validators.required, Validators.pattern]],
      // publishedDate: ['', [Validators.required]],
      // isActive: ['', [Validators.required]],
      // contentType: ['', [Validators.required, Validators.pattern]],
      // content: ['', [Validators.required, Validators.pattern]]
      logo: ['', []],
      title: ['', []],
      description: ['', []],
      category: ['', []],
      price: ['', []],
      author: ['', []],
      publisher: ['', []],
      publishedDate: ['', []],
      isActive: ['', []],
      contentType: ['', []],
      content: ['', []]
    });
  }

  //Add user form actions
  get f() { return this.bookForm.controls; }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.bookForm.invalid) {
      return;
    }
    //True if all the fields are filled
    if (this.submitted) {
      this.createBook();
    }
  }

  onFileChange(event: any) {
    this.file = event.target.files[0];
    // console.log(this.file);
  }

  //create new book
  createBook() {
    //     let bytes: any[] = [];
    //     const arrayBuffer = await this.file.arrayBuffer()
    //     const uint8array = new Uint8Array(arrayBuffer)
    //     console.log(uint8array);
    //     var base64 = btoa(String.fromCharCode(null, uint8array));
    // var url = 'data:image/jpeg;base64,' + base64;
    this.BookContentList.push(this.bookContent);
    this.book.bookContentDetails = this.BookContentList;
    const observables = this.bookService.createBook(this.book);
    observables.subscribe(
      (res: any) => {
        // console.log(res);
        this.successSnackBar("Book loaded successfully!");
      }, (error) => {
        this.errorSnackBar("Something went wrong !, Please try again");
        console.log(error);
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
