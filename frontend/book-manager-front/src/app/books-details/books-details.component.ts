import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-books-details',
  templateUrl: './books-details.component.html',
  styleUrls: ['./books-details.component.css']
})
export class BooksDetailsComponent implements OnInit {

  id!: number;
  book!: Books;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private booksService: BooksService
  ) { }

  ngOnInit() {
    this.book = new Books();
    this.id = this.route.snapshot.params['id'];
    this.booksService.getBook(this.id).subscribe(data => {
      console.log(data);
      this.book = data;
    },
    error => console.log(error));
  }

  list() {
    this.router.navigate(['/books']);
  }
}
