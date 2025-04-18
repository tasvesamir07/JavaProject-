package com.tasvealsamir.Bookmanagement.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Publication {
    @Id

    private Long publicationId;

    private String publicationName;
    private String publicationAddress;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Dhaka")
    private Date publicationFounded;
    private String publicationWebsite;
    private String publicationEmail;
    private String publicationPhone;

    @JsonIgnore
    @OneToMany(mappedBy = "publication")
    private List<Book> books;


    public Publication() {
    }


    public Publication(Long publicationId, String publicationName, String publicationAddress,
                       Date publicationFounded, String publicationWebsite,
                       String publicationEmail, String publicationPhone) {
        this.publicationId = publicationId;
        this.publicationName = publicationName;
        this.publicationAddress = publicationAddress;
        this.publicationFounded = publicationFounded;
        this.publicationWebsite = publicationWebsite;
        this.publicationEmail = publicationEmail;
        this.publicationPhone = publicationPhone;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public String getPublicationAddress() {
        return publicationAddress;
    }

    public void setPublicationAddress(String publicationAddress) {
        this.publicationAddress = publicationAddress;
    }

    public Date getPublicationFounded() {
        return publicationFounded;
    }

    public void setPublicationFounded(Date publicationFounded) {
        this.publicationFounded = publicationFounded;
    }

    public String getPublicationWebsite() {
        return publicationWebsite;
    }

    public void setPublicationWebsite(String publicationWebsite) {
        this.publicationWebsite = publicationWebsite;
    }

    public String getPublicationEmail() {
        return publicationEmail;
    }

    public void setPublicationEmail(String publicationEmail) {
        this.publicationEmail = publicationEmail;
    }

    public String getPublicationPhone() {
        return publicationPhone;
    }

    public void setPublicationPhone(String publicationPhone) {
        this.publicationPhone = publicationPhone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}