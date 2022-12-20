import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/Todo';
import { Store, select } from '@ngrx/store';
import { TodoRemove } from 'src/app/actions/todo.action';

@Component({
  selector: 'app-todo-component',
  templateUrl: './todo-component.component.html',
  styleUrls: ['./todo-component.component.css']
})
export class TodoComponentComponent implements OnInit {

  todos: Todo[];

  constructor(private store: Store<{ todos: Todo[] }>) {
    store.pipe(select('todos')).subscribe((value) => {
      this.todos = value;
      console.log(value);
    });
  }

  deleteTodo(index: number){
     this.store.dispatch(new TodoRemove(index));
  }

  ngOnInit(): void {
  }

}
