import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './Components/about/about.component';
import { ContactusComponent } from './Components/contactus/contactus.component';
import { HomeComponent } from './Components/home/home.component';
import { PipesComponent } from './Components/pipes/pipes.component';
import { RegUserComponent } from './Components/reg-user/reg-user.component';
import { UserformComponent } from './Components/userform/userform.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "register", component: UserformComponent },
  { path:"reg", component: RegUserComponent},
  { path:"about", component: AboutComponent},
  { path:"contactus", component: ContactusComponent},
  { path:"pipe", component: PipesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
