package encapspoly;
import java.util.*;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
        this.isReserved = true;
    }

    public String getBorrower() {
        return borrower;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved for: " + borrowerName);
        } else {
            System.out.println("Book already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved for: " + borrowerName);
        } else {
            System.out.println("Magazine already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved for: " + borrowerName);
        } else {
            System.out.println("DVD already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "The Alchemist", "Paulo Coelho"));
        items.add(new Magazine("M202", "National Geographic", "Various"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Available? " + reservable.checkAvailability());
                reservable.reserveItem("John Doe");
                System.out.println("Available after reserve? " + reservable.checkAvailability());
            }

            System.out.println("-----------------------------------");
        }
    }
}
