package com.besmart.hw1.part1;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name,Author[] authors, double price) {
        this.name = name;
        this.authors = new Author[authors.length];
        for (int i=0; i<authors.length; i++) {
            this.authors[i] = new Author(authors[i].getName(), authors[i].getEmail(), authors[i].getGender());
        }
        //this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = new Author[authors.length];
        for (int i=0; i<authors.length; i++) {
            this.authors[i] = new Author(authors[i].getName(), authors[i].getEmail(), authors[i].getGender());
        }
        //this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        String allAuthorsInformation = new String();
        for (Author auth: authors)
            allAuthorsInformation += auth.toString()+" ";
        return "Book[name="+name+", authors={"+allAuthorsInformation+"}, price="+price+", qty="+qty+"]";
    }

    public String getAuthorsNames() {
        String authorsName = new String();
        for (Author auth: authors)
            authorsName+= auth.getName()+" ";
        return authorsName;
    }
}
