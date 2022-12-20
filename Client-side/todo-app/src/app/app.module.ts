import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StoreModule } from '@ngrx/store/src';
import { TodoReducer } from './reducers/todo.reducer';
import { TodoComponentComponent } from './components/todo-component/todo-component.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    StoreModule.forRoot({ todos: TodoReducer })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
