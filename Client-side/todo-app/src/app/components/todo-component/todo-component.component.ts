import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/Todo';

@Component({
  selector: 'app-todo-component',
  templateUrl: './todo-component.component.html',
  styleUrls: ['./todo-component.component.css']
})
export class TodoComponentComponent implements OnInit {

  todos: Todo[];

  constructor() { }

  ngOnInit(): void {
  }

}
