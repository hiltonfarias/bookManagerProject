import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Books } from '../books';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-create-books',
  templateUrl: './create-books.component.html',
  styleUrls: ['./create-books.component.css']
})
export class CreateBooksComponent implements OnInit {

  book: Books = new Books();
  submitted = false;

  constructor(private bookService: BooksService, private router: Router) { }

  ngOnInit(){
  }

  newBook(): void {
    this.submitted = false;
    this.book = new Books();
  }

  save() {
    this.bookService.createBook(this.book).subscribe(data => {
      console.log(data);
      this.book = new Books();
      this.gotoList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  gotoList() {
    this.router.navigate(['/books']);
  }

}
