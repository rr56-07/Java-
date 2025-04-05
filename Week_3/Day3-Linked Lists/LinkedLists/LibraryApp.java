package DataStructures.LinkedLists;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null;

    public void addBookAtBeginning(Book newBook) {
        if (head == null) {
            head = newBook;
            return;
        }
        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    public void addBookAtEnd(Book newBook) {
        if (head == null) {
            head = newBook;
            return;
        }
        Book temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newBook;
        newBook.prev = temp;
    }

    public void addBookAtPosition(Book newBook, int position) {
        if (position <= 1 || head == null) {
            addBookAtBeginning(newBook);
            return;
        }
        Book temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newBook;
        }
        temp.next = newBook;
    }

    public void removeBookById(int bookId) {
        if (head == null) return;

        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found by author: " + author);
    }

    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Book availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in forward order:");
        Book temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println("Books in reverse order:");
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    public void countTotalBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total books in library: " + count);
    }

    private void printBook(Book book) {
        System.out.println("ID: " + book.bookId + ", Title: " + book.title + ", Author: " + book.author +
                           ", Genre: " + book.genre + ", Available: " + (book.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd(new Book("1984", "George Orwell", "Dystopian", 101, true));
        library.addBookAtBeginning(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true));
        library.addBookAtPosition(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 103, false), 2);

        library.displayBooksForward();
        library.displayBooksReverse();

        System.out.println("\nSearch by title:");
        library.searchByTitle("1984");

        System.out.println("\nSearch by author:");
        library.searchByAuthor("Harper Lee");

        System.out.println("\nUpdating availability for ID 103...");
        library.updateAvailability(103, true);

        System.out.println("\nRemoving book with ID 102...");
        library.removeBookById(102);

        library.displayBooksForward();
        library.countTotalBooks();
    }
}
