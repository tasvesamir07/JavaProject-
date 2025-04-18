package com.tasvealsamir.Bookmanagement.Service;

import com.tasvealsamir.Bookmanagement.Models.Book;
import com.tasvealsamir.Bookmanagement.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public boolean updateBook(Long bookId, Book book) {
        Optional<Book> existingBook = bookRepository.findById(bookId);

        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();


            bookToUpdate.setBookName(book.getBookName());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setBookDescription(book.getBookDescription());
            bookToUpdate.setPublication(book.getPublication());
            bookToUpdate.setPublishedDate(book.getPublishedDate());



            bookRepository.save(bookToUpdate);
            return true;
        }

        return false;
    }

    public Long getLastBookId() {
        Long lastid = bookRepository.findLastBookId();
        if(lastid == null) {
            return 0L;
        }
        return lastid;
    }

    public boolean deleteBook(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }

    public boolean existsById(Long bookId) {
        return bookRepository.existsById(bookId);
    }

    public boolean removeCoverImage(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();


            book.setCoverImage(null);
            book.setImageContentType(null);


            bookRepository.save(book);

            return true;
        }

        return false;
    }
}