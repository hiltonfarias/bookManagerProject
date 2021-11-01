package com.github.hiltonfarias.bookManager.resource;

import com.github.hiltonfarias.bookManager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseResource<T> {

    protected ResponseEntity<T> answerCreatedItem(T object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    protected ResponseEntity<T> answerNotFoundItem() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<T> answerSuccess(T object) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    protected ResponseEntity<Void> answerDeletedSuccess() { return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); }

    protected ResponseEntity<T> answerSuccessWithItem(T object) {
        return ResponseEntity.status(HttpStatus.OK).body(object);
    }

    protected ResponseEntity<T> answerUnsuccessfulRequest() {
        return ResponseEntity.badRequest().build();
    }

    protected ResponseEntity<List<T>> answerEmptyList() {
        List<T> emptyList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(emptyList);
    }

    protected ResponseEntity<List<T>> answerListOfItems(List<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    protected ResponseEntity<Page<T>> answerListOfItemsPaged(Page<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
}
