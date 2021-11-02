import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateBooksComponent } from './create-books/create-books.component';
import { BooksDetailsComponent } from './books-details/books-details.component';
import { BooksListComponent } from './books-list/books-list.component';
import { UpdateBooksComponent } from './update-books/update-books.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    CreateBooksComponent,
    BooksDetailsComponent,
    BooksListComponent,
    UpdateBooksComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
