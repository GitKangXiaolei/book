package com.example.book.entity;

import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Alias("return")
public class Returned {
    private Integer id;
    private LocalDate returnedDate;
    private Borrowing borrowId;

    public Returned() {
    }

    public Returned(Integer id, LocalDate returnedDate, Borrowing borrowId) {
        this.id = id;
        this.returnedDate = returnedDate;
        this.borrowId = borrowId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Borrowing getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Borrowing borrowId) {
        this.borrowId = borrowId;
    }

    @Override
    public String toString() {
        return "Returned{" +
                "id=" + id +
                ", returnedDate=" + returnedDate +
                ", borrowId=" + borrowId +
                '}';
    }
}
