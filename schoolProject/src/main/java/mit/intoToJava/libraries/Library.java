package mit.intoToJava.libraries;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class Library implements ILibrary{
    String libraryAddress;
    List<Book> books;

    public Library(String libraryAddress) {
        this.libraryAddress = libraryAddress;
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if(Optional.ofNullable(book).isPresent())
            books.add(book);
    }

    /**
     * This method walks through the books and  print the title if and only if book object is not borrowed.
     * Otherwise, notify users if the library is empty or all of the books are checked out.
     * => Print all books that are not checked out.
     */
    public void printAvailableBooks() {
        if(books.size() == 0 || !books.stream().anyMatch(book -> !book.isBorrowed()))
            System.out.println("No book found or all books are borrowed");
        else
        books.stream()
                    .filter(book -> !book.isBorrowed()) //filter all books not borrowed
                    .map(Book::getTitle) // print only book title
                    .forEach(book-> System.out.print(" " + book));

    }

    /**
     * This method walks through the books list, to see if the book with given title exists.
     * If it does & it's not borrowed, it borrows it and alerts the user they've successfully checked it out.
     * If it does exist and its borrowed, it alerts the user that the book is already borrowed.
     * If the book does not exist in the library, the user is alerted.
     *
     */
    public Book borrowBook(String bookTitle) {
        final Book canBorrow = books.stream()
                .filter(book -> bookTitle.equals(bookTitle) && !book.isBorrowed()) //filter books by title that is not checked out
                .findAny()
                .get();
        if(Optional.ofNullable(canBorrow).isPresent()){
            canBorrow.borrowed(); // borrow the book
            System.out.println("You're successfully borrowed " + canBorrow.getTitle());
            return canBorrow;
        } else {
            System.out.println("Sorry, this book is not in our catalog. or this book is already borrowed." );
            return null;
        }
    }

    /**
     * This method walks through the books list, search for the book (by title and status, borrowed) when found
     * then the book will be returned and the user will be notified. If book is not found in the library then
     * the user is alerted.
     */
    public void returnBook(String bookTitle) {
        AtomicReference<Boolean> found = new AtomicReference<>(false);
        books.stream().filter(book -> book.getTitle().equals(bookTitle) && book.isBorrowed())
                .forEach(book -> {
                    book.returned();
                    System.out.println("You successfully returned " + bookTitle);
                    found.set(true);
                });
        if(!found.get())
            System.out.println("Your book was not found in the library");
    }
    public void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }


}
