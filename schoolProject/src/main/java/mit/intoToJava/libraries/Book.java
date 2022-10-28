package mit.intoToJava.libraries;

import lombok.Data;

/**
 * For this assignment to abstract a book only title and status is enough
 */
@Data
public class Book {
    private String title;
    private boolean borrowed;

    public Book(String title) {
        this.title = title;
    }
    public void borrowed() {
        this.borrowed = true; // Marks the book as rented
    }

    public void returned() {
        this.borrowed = false; // Marks the book as not rented
    }
}
