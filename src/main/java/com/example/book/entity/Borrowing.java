package com.example.book.entity;

import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Alias("borrow")
public class Borrowing {
    private Integer id;
    private User cardNumber;
    private Book bookId;
    private LocalDate borrowDate;

    public Borrowing() {
    }

    public Borrowing(Integer id, User cardNumber, Book bookId, LocalDate borrowDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(User cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
