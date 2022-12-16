import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-reg-user',
  templateUrl: './reg-user.component.html',
  styleUrls: ['./reg-user.component.css']
})
export class RegUserComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    //initalize when component starts
    const promise = this.userService.getUsers();
    promise.subscribe(
      (res) => {
        console.log(res);
        this.users = res as User[];
      });
  }

  deleteUser(user: any, index: any){
    const observable = this.userService.deleteUser(user);
    observable.subscribe(
      (res) => {
        console.log(res);
        this.users.splice(index, 1);
      }
    )
  }

  sortUsers(){
    this.users.sort((user1, user2) => {
        return user1.age - user2.age;
    })
  }

}
