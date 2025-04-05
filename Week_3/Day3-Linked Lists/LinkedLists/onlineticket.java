package DataStructures.LinkedLists;

class Ticket {
    String ticketId, customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;

    public void addTicket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicket(String ticketId) {
        if (head == null) return;
        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId.equals(ticketId)) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println("TicketID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found -> TicketID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No ticket found for: " + keyword);
    }

    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class onlineticket {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket("T001", "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket("T002", "Bob", "Matrix", "B2", "11:00 AM");
        system.addTicket("T003", "Charlie", "Inception", "C3", "12:00 PM");

        system.displayTickets();

        system.searchTicket("Inception");
        system.removeTicket("T002");
        system.displayTickets();

        System.out.println("Total Tickets: " + system.countTickets());
    }
}
