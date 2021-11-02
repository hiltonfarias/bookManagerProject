import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-update-books',
  templateUrl: './update-books.component.html',
  styleUrls: ['./update-books.component.css']
})
export class UpdateBooksComponent implements OnInit {

  id!: number;
  book!: Books;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private bookService: BooksService
  ) { }

  ngOnInit() {
    this.book = new Books();
    this.id = this.route.snapshot.params['id'];
    this.bookService.getBook(this.id).subscribe(data => {
      console.log(data);
      this.book = data;
    },
    error => console.log(error));
  }

  updateBook() {
    this.bookService.updateBook(this.id, this.book).subscribe(data => {
      console.log(data);
      this.book = new Books();
      this.gotoList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.updateBook();
  }

  gotoList() {
    this.router.navigate(['/books']);
  }
}
