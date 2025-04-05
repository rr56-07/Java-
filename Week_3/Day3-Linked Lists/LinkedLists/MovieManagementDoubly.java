package DataStructures.LinkedLists;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev, next;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        else
            tail = newNode;
        head = newNode;
        System.out.println("Added '" + title + "' at the beginning.");
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Added '" + title + "' at the end.");
    }

    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1 || head == null) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int count = 1;

        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
        System.out.println("Added '" + title + "' at position " + position + ".");
    }

    public void removeMovieByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;

                if (current.next != null)
                    current.next.prev = current.prev;
                else
                    tail = current.prev;

                System.out.println("Removed movie '" + title + "'.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    public void searchByDirector(String director) {
        boolean found = false;
        MovieNode current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("No movies found for director '" + director + "'.");
    }

    public void searchByRating(double rating) {
        boolean found = false;
        MovieNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("No movies found with rating '" + rating + "'.");
    }

    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Updating rating of '" + title + "' from " + current.rating + " to " + newRating);
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found to update rating.");
    }

    public void displayForward() {
        System.out.println("\nMovies in forward order:");
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        System.out.println("\nMovies in reverse order:");
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode current = tail;
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    private void printMovie(MovieNode movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director +
                ", Year: " + movie.year + ", Rating: " + movie.rating);
    }
}
public class MovieManagementDoubly {
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addMovieAtBeginning("The Matrix", "The Wachowskis", 1999, 8.7);
        mms.addMovieAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 2);

        mms.displayForward();
        mms.displayReverse();

        mms.searchByDirector("Christopher Nolan");
        mms.searchByRating(8.7);

        mms.updateRating("The Matrix", 9.0);
        mms.displayForward();

        mms.removeMovieByTitle("Inception");
        mms.displayForward();
    }
}
