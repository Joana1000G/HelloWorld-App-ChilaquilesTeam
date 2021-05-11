package com.example.hellochilaquilesteam.models;

import java.time.Year;

public class Book {

    private int id;
    private String name;
    private String author;
    private String year;

    public Book(int id, String author, String year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() { return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAuthor(String author) {return author;}

    public void setAuthor(String author) {this.author = author;}

    public String getYear() {return year;}

    public void setYear(String year) {this.year = year;}
}
