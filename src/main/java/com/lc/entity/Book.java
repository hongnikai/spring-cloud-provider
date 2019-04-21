package com.lc.entity;

public class Book {

    public String name;

    public int page;

    public String author;

    public String press;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Book(String name, int page, String author, String press) {
        this.name = name;
        this.page = page;
        this.author = author;
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", page=" + page +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                '}';
    }
}
