import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BookService } from 'src/app/services/book.service';
import { Notification } from 'src/app/models/book';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class NotificationComponent implements OnInit {

  notifications: Notification[] = [];

  constructor(
    private bookService: BookService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.getAllNotification();
  }

    //get all notifications
    getAllNotification() {
      const promise = this.bookService.getAllNotification();
      promise.subscribe(
        (res) => {
          console.log(res);
          this.notifications = res as Notification[];
          this.successSnackBar("Notification loaded successfully!");
        }, (err) => {
          this.errorSnackBar("Something went wrong !, Please try again");
          console.log(err);
        }
      );
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
