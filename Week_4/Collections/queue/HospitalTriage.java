package queue;

import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {

    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity)
        );

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}
