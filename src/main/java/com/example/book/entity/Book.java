package com.example.book.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("book")
public class Book implements Serializable {
    private Integer id;
    private String title;
    private String press;
    private BookType typeId;
    private String address;
    private Integer numbers;

    public Book() {
    }

    public Book(Integer id, String title, String press, BookType typeId, String address, Integer numbers) {
        this.id = id;
        this.title = title;
        this.press = press;
        this.typeId = typeId;
        this.address = address;
        this.numbers = numbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public BookType getTypeId() {
        return typeId;
    }

    public void setTypeId(BookType typeId) {
        this.typeId = typeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", press='" + press + '\'' +
                ", typeId=" + typeId +
                ", address='" + address + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}