package mit.intoToJava.libraries;

public interface ILibrary {

    void addBook(Book book);
    void printAvailableBooks();
    Book borrowBook(String bookTitle);
    void returnBook(String bookTitle);
}
