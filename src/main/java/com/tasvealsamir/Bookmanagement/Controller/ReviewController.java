package com.tasvealsamir.Bookmanagement.Controller;


import com.tasvealsamir.Bookmanagement.Models.*;
import com.tasvealsamir.Bookmanagement.Models.Review;
import com.tasvealsamir.Bookmanagement.Models.Composite;
import com.tasvealsamir.Bookmanagement.Service.BookService;
import com.tasvealsamir.Bookmanagement.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/{bookId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long bookId) {
        return new ResponseEntity<>(reviewService.getAllReviews(bookId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long bookId, @PathVariable Long reviewId) {
        Composite id = new Composite(bookId, reviewId);
        Review review = reviewService.getReview(id);
        return review != null
                ? new ResponseEntity<>(review, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<String> addReview(@PathVariable Long bookId, @RequestBody Review review) {
        try {
            Book book = bookService.getBookById(bookId);
            if (book == null) {
                return new ResponseEntity<>("No book found", HttpStatus.NOT_FOUND);
            }

            List<Review> reviews = book.getReviews();
            Long reviewId = 1L;
            if (!reviews.isEmpty()) {
                Review lastReview = reviews.get(reviews.size() - 1);
                reviewId = lastReview.getId().getReviewId() + 1;
            }

            Composite id = new Composite(bookId, reviewId);
            review.setId(id);
            review.setBooks(book);

            reviewService.addReview(bookId, review);

            return new ResponseEntity<>("Review Added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long bookId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review) {
        Composite id = new Composite(bookId, reviewId);
        review.setId(id);
        boolean isUpdated = reviewService.updateReview(id, review);
        return isUpdated
                ? new ResponseEntity<>("Review Updated", HttpStatus.OK)
                : new ResponseEntity<>("Review Not Updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long bookId,
                                               @PathVariable Long reviewId) {
        Composite id = new Composite(bookId, reviewId);
        boolean isDeleted = reviewService.deleteReview(id);
        return isDeleted
                ? new ResponseEntity<>("Review Deleted", HttpStatus.OK)
                : new ResponseEntity<>("Review Not Deleted", HttpStatus.NOT_FOUND);
    }
}
