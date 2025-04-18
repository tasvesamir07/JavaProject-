package com.tasvealsamir.Bookmanagement.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    private Long bookId;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id") // Explicitly name the column
    private Author author;

    private String bookDescription;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Dhaka")
    private Date publishedDate;

    @Lob
    @Column(name = "cover_image", columnDefinition="LONGBLOB")
    private byte[] coverImage;
    private String imageContentType;

    @ManyToOne
    @JoinColumn(name = "publication_id") // Explicitly name the column
    private Publication publication;

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;


    public Book() {
    }

    public Book(Long bookId, String bookName, Author author, String bookDescription, Date publishedDate, Publication publication, List<Review> reviews) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.bookDescription = bookDescription;
        this.publishedDate = publishedDate;
        this.publication = publication;
        this.reviews = reviews;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public byte[] getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(byte[] coverImage) {
        this.coverImage = coverImage;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
}