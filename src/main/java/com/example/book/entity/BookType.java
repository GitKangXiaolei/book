package com.example.book.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("bookType")
public class BookType implements Serializable {
    private Integer id;
    private String type;

    public BookType() {
    }

    public BookType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
