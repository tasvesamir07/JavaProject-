package com.tasvealsamir.Bookmanagement.Controller;

import com.tasvealsamir.Bookmanagement.Models.Book;
import com.tasvealsamir.Bookmanagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null)
            return new ResponseEntity<>(book, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        try {
            Long lastid = bookService.getLastBookId();
            book.setBookId(++lastid);
            bookService.addBook(book);
            return new ResponseEntity<>("Book Added Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding book: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        if (book == null) {
            return new ResponseEntity<>("Invalid book data", HttpStatus.BAD_REQUEST);
        }

        if (!bookService.existsById(bookId)) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }

        try {
            book.setBookId(bookId);  // Ensure the ID is set correctly
            boolean updated = bookService.updateBook(bookId, book);

            if (updated) {
                return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update book", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating book: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        boolean found = bookService.existsById(bookId);
        if (found) {
            bookService.deleteBook(bookId);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book is not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/upload-image/{bookId}")
    public ResponseEntity<String> uploadCoverImage(
            @PathVariable Long bookId,
            @RequestParam("image") MultipartFile imageFile) {

        try {
            Book book = bookService.getBookById(bookId);
            if (book == null) {
                return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
            }

            book.setCoverImage(imageFile.getBytes());
            book.setImageContentType(imageFile.getContentType());
            bookService.updateBook(bookId, book);

            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error uploading image: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cover-image/{bookId}")
    public ResponseEntity<byte[]> getCoverImage(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        if (book == null || book.getCoverImage() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(
                book.getImageContentType() != null ? book.getImageContentType() : "image/jpeg"));

        return new ResponseEntity<>(book.getCoverImage(), headers, HttpStatus.OK);
    }

    @DeleteMapping("/remove-cover/{bookId}")
    public ResponseEntity<String> removeCoverImage(@PathVariable Long bookId) {
        try {
            boolean removed = bookService.removeCoverImage(bookId);
            if (removed) {
                return ResponseEntity.ok("Cover image removed successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error removing cover image: " + e.getMessage());
        }
    }
}