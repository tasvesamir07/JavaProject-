package com.tasvealsamir.Bookmanagement.Service;

import com.tasvealsamir.Bookmanagement.Models.Author;
import com.tasvealsamir.Bookmanagement.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public boolean deleteAuthorById(Long id) {
        if(authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return authorRepository.existsById(id);
    }

    public Long getLastAuthorId() {
        Long lastid = authorRepository.findLastAuthorId();
        if(lastid == null) {
            return 0L;
        }
        return lastid;
    }

    public List<Author> findAuthorsByNameContaining(String name) {
        return authorRepository.findByAuthorNameContainingIgnoreCase(name);
    }

    public List<Author> findAuthorsByBirthplace(String birthplace) {
        return authorRepository.findByAuthorBirthplaceIgnoreCase(birthplace);
    }

    public boolean updateAuthor(Long authorId, Author author) {
        Optional<Author> existingAuthor = authorRepository.findById(authorId);

        if (existingAuthor.isPresent()) {
            Author authorToUpdate = existingAuthor.get();


            authorToUpdate.setAuthorName(author.getAuthorName());
            authorToUpdate.setAuthorBirthdate(author.getAuthorBirthdate());
            authorToUpdate.setAuthorBirthplace(author.getAuthorBirthplace());
            authorToUpdate.setAuthorNationality(author.getAuthorNationality());
            authorToUpdate.setAuthorBiography(author.getAuthorBiography());



            authorRepository.save(authorToUpdate);
            return true;
        }

        return false;
    }

    public boolean removeProfileImage(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();

            author.setProfileImage(null);
            author.setImageContentType(null);

            authorRepository.save(author);

            return true;
        }

        return false;
    }
}