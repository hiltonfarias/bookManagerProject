import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {
  books!: Observable<Books[]>;

  constructor(private booksService: BooksService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.books = this.booksService.getBookList();
  }

  deleteBook(id: number) {
    this.booksService.deleteBook(id)
      .subscribe(data => {
                  console.log(data);
                  this.reloadData();
      },
      error =>console.log(error));
  }

  bookDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  updateBook(id: number) {
    this.router.navigate(['update', id]);
  }

}
