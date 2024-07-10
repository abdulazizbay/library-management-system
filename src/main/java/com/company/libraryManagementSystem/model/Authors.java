package com.company.libraryManagementSystem.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="authors")
public class Authors {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    @Column( nullable = false)
    private Date dateOfBirth;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Authors() {}
}
