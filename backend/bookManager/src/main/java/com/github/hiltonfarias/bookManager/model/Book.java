package com.github.hiltonfarias.bookManager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "BOOK")
public class Book extends EntityBase {

    private static final Long serialVersionUID = 1L;

    @Column(name = "BOOK_AUTHOR", nullable = false)
    private String author;

    @Column(name = "BOOK_TITLE", nullable = false)
    private String title;

    @Column(name = "BOOK_PUBLISHER", nullable = false)
    private String publisher;

    @Column(name = "BOOK_LANGUAGE", nullable = false)
    private String language;

    @Column(name = "BOOK_COMMON_COVER", nullable = false)
    private String commonCover;

    @Column(name = "BOOK_ISBN", nullable = false)
    private String isbn;

    @Column(name = "BOOK_REGISTRATION_TIME", nullable = false)
    private LocalDateTime registrationTime;

    @Column(name = "BOOK_YEAR", nullable = false)
    private String year;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "BOOK_USER")
    private User users;

}
