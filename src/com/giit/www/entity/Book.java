package com.giit.www.entity;

/**
 * Created by c0de8ug on 16-2-9.
 */
public class Book {

    String bookTitle;
    String isbn;
    String dataOfPrinting;
    String author;
    String press;
    String category;
    String unitPrice;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDataOfPrinting() {
        return dataOfPrinting;
    }

    public void setDataOfPrinting(String dataOfPrinting) {
        this.dataOfPrinting = dataOfPrinting;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
