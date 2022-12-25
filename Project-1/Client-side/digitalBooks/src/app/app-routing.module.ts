import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './components/add-book/add-book.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SearchComponent } from './components/search/search.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { SubscribedBookComponent } from './components/subscribed-book/subscribed-book.component';
import { ViewBookComponent } from './components/view-book/view-book.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignUpComponent },
  { path: "search-books", component: SearchComponent },
  { path: "add-book", component: AddBookComponent },
  { path: "author/view-book", component: ViewBookComponent },
  { path: "reader/subscribed-book", component: SubscribedBookComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
