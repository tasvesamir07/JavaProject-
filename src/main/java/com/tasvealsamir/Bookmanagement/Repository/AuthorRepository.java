package com.tasvealsamir.Bookmanagement.Repository;

import com.tasvealsamir.Bookmanagement.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT MAX(a.id) FROM Author a")
    Long findLastAuthorId();
    List<Author> findByAuthorNameContainingIgnoreCase(String name);
    List<Author> findByAuthorBirthplaceIgnoreCase(String birthplace);

}
