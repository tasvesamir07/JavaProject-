package com.tasvealsamir.Bookmanagement.Controller;
import com.tasvealsamir.Bookmanagement.Models.Author;
import com.tasvealsamir.Bookmanagement.Service.AuthorService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/Author")
@CrossOrigin
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.findAuthorById(id);
        if(author!=null)
            return new ResponseEntity<>(author, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        try {
            Long lastid = authorService.getLastAuthorId();
            author.setAuthorId(++lastid);
            authorService.saveAuthor(author);
            return new ResponseEntity<>("Author Added Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        if (!authorService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        author.setAuthorId(id);
        Author updatedAuthor = authorService.saveAuthor(author);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        boolean deleted = authorService.deleteAuthorById(id);
        if(deleted) {
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Author ID not found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/upload-image/{authorId}")
    public ResponseEntity<String> uploadProfileImage(
            @PathVariable Long authorId,
            @RequestParam("image") MultipartFile imageFile) {

        try {
            Author author = authorService.findAuthorById(authorId);
            if (author == null) {
                return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
            }

            author.setProfileImage(imageFile.getBytes());
            author.setImageContentType(imageFile.getContentType());
            authorService.saveAuthor(author);

            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error uploading image: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/profile-image/{authorId}")
    public ResponseEntity<byte[]> getProfileImage(@PathVariable Long authorId) {
        Author author = authorService.findAuthorById(authorId);
        if (author == null || author.getProfileImage() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(
                author.getImageContentType() != null ? author.getImageContentType() : "image/jpeg"));

        return new ResponseEntity<>(author.getProfileImage(), headers, HttpStatus.OK);
    }

    @DeleteMapping("/remove-profile-image/{authorId}")
    public ResponseEntity<String> removeProfileImage(@PathVariable Long authorId) {
        try {
            boolean removed = authorService.removeProfileImage(authorId);
            if (removed) {
                return ResponseEntity.ok("Profile image removed successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error removing profile image: " + e.getMessage());
        }
    }
}