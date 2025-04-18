package com.tasvealsamir.Bookmanagement.Repository;

import com.tasvealsamir.Bookmanagement.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT MAX(b.id) FROM Book b")
    Long findLastBookId();


}
