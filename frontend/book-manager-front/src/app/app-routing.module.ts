import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksDetailsComponent } from './books-details/books-details.component';
import { BooksListComponent } from './books-list/books-list.component';
import { CreateBooksComponent } from './create-books/create-books.component';
import { UpdateBooksComponent } from './update-books/update-books.component';

const routes: Routes = [
  { path: '', redirectTo: '/books', pathMatch: 'full' },
  { path: 'books', component: BooksListComponent },
  { path: 'add', component: CreateBooksComponent },
  { path: 'update/:id', component: UpdateBooksComponent },
  { path: 'details/:id', component: BooksDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
