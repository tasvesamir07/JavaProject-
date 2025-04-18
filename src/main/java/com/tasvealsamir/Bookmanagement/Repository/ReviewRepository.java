package com.tasvealsamir.Bookmanagement.Repository;

import com.tasvealsamir.Bookmanagement.Models.Review;
import com.tasvealsamir.Bookmanagement.Models.Composite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Composite> {
    List<Review> findByBooks_BookId(Long bookId);
}
