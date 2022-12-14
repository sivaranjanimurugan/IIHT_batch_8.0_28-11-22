import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { UserformComponent } from './Components/userform/userform.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { AboutComponent } from './Components/about/about.component';
import { ContactusComponent } from './Components/contactus/contactus.component';
import { HttpClientModule } from '@angular/common/http';
import { RegUserComponent } from './Components/reg-user/reg-user.component';
import { PipesComponent } from './Components/pipes/pipes.component';
import { EllipsisPipe } from './pipe/ellipsis.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserformComponent,
    NavbarComponent,
    AboutComponent,
    ContactusComponent,
    RegUserComponent,
    PipesComponent,
    EllipsisPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NoopAnimationsModule,
    MatListModule,
    MatMenuModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
