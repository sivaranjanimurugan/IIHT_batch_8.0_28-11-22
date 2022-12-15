import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL="http://localhost:5000";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  saveUser(user: {
    firstname: String;
    lastname: String;
    age: number;
    gender: String;
    email: String;
  }) {
       return this.http.post(BASE_URL+"/users", user);
  }
}
