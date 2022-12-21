import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

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
export class UserService {

  constructor(private http: HttpClient) { }

  //create new user
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

  //login
  login(request: {
    username: string;
    password: string;
  }) {
    return this.http.post(BASE_URL + "/sign-in", request);
  }
}
