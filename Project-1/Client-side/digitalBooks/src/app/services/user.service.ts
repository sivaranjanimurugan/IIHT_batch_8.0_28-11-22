import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = "http://localhost:8085/api/v1/digitalbooks";

const headers = new HttpHeaders({
  // 'Content-Type': 'application/json',
  'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaXZhIiwiZXhwIjoxNjcxNjE3MjE2LCJpYXQiOjE2NzE1OTkyMTZ9.ORBOHuA9RkS1bqCsC73Pj6xqqh0h09cKSOqH1O2l7sXtnP0XM5Apxix3ei4P1yFiIvTjSdv1LU6cDwT16bYOsQ'
})

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
    return this.http.post(BASE_URL + "/sign-up", user, { headers: headers });
  }
}
