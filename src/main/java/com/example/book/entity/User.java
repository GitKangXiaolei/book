package com.example.book.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("user")
public class User {
    private Integer cardNumber;
    private String password;
    private String name;
    private String IDNumber;
    private String phoneNumber;
    private Integer deposit;
    private List<Book> booklist;

    public User() {
    }

    public User(Integer cardNumber, String password, String name, String IDNumber, String phoneNumber, Integer deposit) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.name = name;
        this.IDNumber = IDNumber;
        this.phoneNumber = phoneNumber;
        this.deposit = deposit;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }

    @Override
    public String toString() {
        return "User{" +
                "cardNumber=" + cardNumber +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deposit=" + deposit +
                '}';
    }
}
