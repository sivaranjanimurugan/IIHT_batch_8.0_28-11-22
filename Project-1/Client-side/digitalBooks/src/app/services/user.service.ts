import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = "http://localhost:8085/api/v1/digitalbooks";

const reqHeaders = new HttpHeaders({
  'Content-Type': 'application/json',
  'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaXZhIiwiZXhwIjoxNjcxNjM1Mjk0LCJpYXQiOjE2NzE2MTcyOTR9.aGZlZC7MxPr8nZ5_Ove_SwnEfC5rxv842ASw_VsdQLu_bm4E7A-vXROFiwBeF3epbeipu9nyLTqtOBh-_oFVuQ'
})

const httpOptions = {
  headers: reqHeaders
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  //create new book
  createUser(user: {
    username: string;
    firstName: string;
    lastName: string;
    role: string;
    email: string;
    password: string;
  }) {
    return this.http.post(BASE_URL + "/sign-up", user, httpOptions);
  }
}
