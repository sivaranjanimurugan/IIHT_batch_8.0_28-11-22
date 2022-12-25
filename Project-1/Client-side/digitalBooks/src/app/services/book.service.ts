import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookContent, SubscribeDetails } from '../models/book';
import { TokenStorageService } from './token-storage.service';

const BASE_URL = "http://localhost:8085/api/v1/digitalbooks";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.tokenService.getToken()
    })
  };

  constructor(
    private http: HttpClient,
    private tokenService: TokenStorageService,
  ) { }

  //search book
  searchBooks(filter: {
    title: string;
    category: string;
    price: number;
    author: string;
  }) {
    return this.http.post(BASE_URL + "/search/by-filter", filter);
  }

  //create new user
  createBook(book: {
    logo: any;
    title: string;
    description: string;
    category: string;
    price: number;
    author: string;
    isActive: boolean;
    publisher: string;
    publishedDate: any;
    bookContentDetails: BookContent[];
  }) {
    return this.http.post(BASE_URL + "/author/book", book, this.httpOptions);
  }

  getAllBooks() {
    return this.http.get(BASE_URL + "/author/" + this.tokenService.getUser().username + "/books", this.httpOptions);
  }

  deleteBook(book: any) {
    return this.http.delete(BASE_URL + "/author/delete/" + book.id, this.httpOptions);
  }

  blockBook(book: any, isActive: boolean) {
    return this.http.put(BASE_URL + "/author/update/is-active/" + book.id, isActive, this.httpOptions);
  }

  subscribeBook(book: any, subDetails: SubscribeDetails) {
    return this.http.put(BASE_URL + "/reader/update/is-subscribe/" + book.id, subDetails, this.httpOptions);
  }

  unsubscribeBook(book: any, subDetails: SubscribeDetails) {
    return this.http.put(BASE_URL + "/reader/update/cancel-subscription/" + book.id, subDetails, this.httpOptions);
  }

  subscribedBooks(subName: string) {
    return this.http.get(BASE_URL + "/reader/getall/by-user/" + subName, this.httpOptions);
  }


}
