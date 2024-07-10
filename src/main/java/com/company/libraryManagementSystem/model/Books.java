package com.company.libraryManagementSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {
    @Id
    private long id;
    @Column(unique=true, nullable = false, length = 100)
    private String title;
    @ManyToOne
    @JoinColumn(name = "authors" , nullable = false)
    private Authors author;
    private String genre;
    public Books() {}

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
