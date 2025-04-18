package com.tasvealsamir.Bookmanagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tasvealsamir.Bookmanagement.Models.Book;
import com.tasvealsamir.Bookmanagement.Models.Composite;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Review {

    @EmbeddedId
    private Composite id;

    private String title;
    private String description;
    private double rating;

    @ManyToOne
    @MapsId("bookId")
    @JsonIgnore
    @JoinColumn(name = "book_id") // Force correct column
    private Book books;


    public Review() {}

    public Review(Composite id, String title, String description, double rating, Book books) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.books = books;
    }

    public Composite getId() {
        return id;
    }

    public void setId(Composite id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return Double.compare(review.rating, rating) == 0 &&
                Objects.equals(id, review.id) &&
                Objects.equals(title, review.title) &&
                Objects.equals(description, review.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, rating);
    }
}
