package com.tasvealsamir.Bookmanagement.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Author {
    @Id
    private Long authorId;
    private String authorName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Dhaka")
    private Date authorBirthdate;
    private String authorBirthplace;
    private String authorNationality;
    private String authorBiography;

    @Lob
    @Column(name = "profile_image", columnDefinition="LONGBLOB")
    private byte[] profileImage;
    private String imageContentType;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public Author(Long authorId, String authorName, Date authorBirthdate,
                  String authorBirthplace, String authorNationality,
                  String authorBiography) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorBirthdate = authorBirthdate;
        this.authorBirthplace = authorBirthplace;
        this.authorNationality = authorNationality;
        this.authorBiography = authorBiography;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getAuthorBirthdate() {
        return authorBirthdate;
    }

    public void setAuthorBirthdate(Date authorBirthdate) {
        this.authorBirthdate = authorBirthdate;
    }

    public String getAuthorBirthplace() {
        return authorBirthplace;
    }

    public void setAuthorBirthplace(String authorBirthplace) {
        this.authorBirthplace = authorBirthplace;
    }

    public String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}