import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookContent } from '../models/book';

const BASE_URL = "http://localhost:8085/api/v1/digitalbooks";

const reqHeaders = new HttpHeaders({
  'Content-Type': 'application/json',
  'Authorization': 'Bearer ' + localStorage.getItem('token')
})

const httpOptions = {
  headers: reqHeaders
};

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(
    private http: HttpClient
  ) { }

  //create new user
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
    bookContentDetails: BookContent;
  }) {
    return this.http.post(BASE_URL + "/author/book", book, httpOptions);
  }

}
