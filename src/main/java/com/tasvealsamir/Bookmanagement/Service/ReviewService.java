package com.tasvealsamir.Bookmanagement.Service;

import com.tasvealsamir.Bookmanagement.Models.Book;
import com.tasvealsamir.Bookmanagement.Models.Review;
import com.tasvealsamir.Bookmanagement.Models.Composite;
import com.tasvealsamir.Bookmanagement.Repository.BookRepository;
import com.tasvealsamir.Bookmanagement.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Review> getAllReviews(Long bookId) {
        return reviewRepository.findByBooks_BookId(bookId);
    }

    public Review getReview(Composite id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        return optionalReview.orElse(null);
    }

    public void addReview(Long bookId, Review review) {
        reviewRepository.save(review);
    }

    public boolean updateReview(Composite id, Review updatedReview) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    public boolean deleteReview(Composite id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
