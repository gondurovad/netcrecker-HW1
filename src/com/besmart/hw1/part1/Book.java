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
    
    @Override
    public int hashCode() {
        int result = 17;
        long tmp = Double.doubleToLongBits(price);

        result = 31*result + name.hashCode();
        result = 31*result + (int)(tmp ^ (tmp >>> 32));
        result = 31*result + qty;

        for (Author author: authors)
            result = 31*result + author.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Book book = (Book)obj;

        if (authors.length != book.authors.length) return false;

        //считаем, что порядок сооавторов не важен
        int count = 0;
        for (int i=0; i<authors.length; i++)
            for (int j=0; j<authors.length; j++)
                if ((authors[i].equals(book.authors[j]))) count++;
        if (count!=authors.length) return false;

        //считаем, что регистр в названии не важен
        return this.name.equalsIgnoreCase(book.name)
                && Double.compare(this.price,book.price)==0
                && this.qty==book.qty;
    }
}
