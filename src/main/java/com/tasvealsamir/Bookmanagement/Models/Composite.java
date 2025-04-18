package com.tasvealsamir.Bookmanagement.Models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Composite implements Serializable {
    private Long bookId;
    private Long reviewId;

    public Composite() {}

    public Composite(Long bookId, Long reviewId) {
        this.bookId = bookId;
        this.reviewId = reviewId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composite)) return false;
        Composite that = (Composite) o;
        return Objects.equals(bookId, that.bookId) && Objects.equals(reviewId, that.reviewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, reviewId);
    }
}
