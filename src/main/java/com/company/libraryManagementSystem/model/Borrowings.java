package com.company.libraryManagementSystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrowings")
public class Borrowings {
    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateOfBorrowing;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateOfReturning;
    @ManyToOne
    @JoinColumn(name = "users", nullable = false)
    private Users user;

    public Borrowings(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public void setDateOfBorrowing(Date dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

    public Date getDateOfReturning() {
        return dateOfReturning;
    }

    public void setDateOfReturning(Date dateOfReturning) {
        this.dateOfReturning = dateOfReturning;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
