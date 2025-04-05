package DataStructures.LinkedLists;

class StudentNode {
    int roll;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    public void addAtBeginning(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Added " + name + " at the beginning.");
    }

    public void addAtEnd(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            System.out.println("Added " + name + " as the first student.");
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Added " + name + " at the end.");
    }

    public void addAtPosition(int position, int roll, String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        StudentNode newNode = new StudentNode(roll, name, age, grade);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Added " + name + " at position " + position + ".");
            return;
        }

        StudentNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position is out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Added " + name + " at position " + position + ".");
    }

    public void deleteByRoll(int roll) {
        StudentNode current = head, prev = null;

        while (current != null && current.roll != roll) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Student not found.");
            return;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = current.next;
        }
        System.out.println("Deleted student with Roll Number " + roll + ".");
    }

    public void searchByRoll(int roll) {
        StudentNode current = head;
        while (current != null) {
            if (current.roll == roll) {
                System.out.println("Found student: Roll: " + current.roll + ", Name: " + current.name +
                        ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    public void updateGrade(int roll, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.roll == roll) {
                System.out.println("Updated grade of " + current.name + " from " + current.grade + " to " + newGrade + ".");
                current.grade = newGrade;
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }
        StudentNode current = head;
        System.out.println("\nStudent Records:");
        while (current != null) {
            System.out.println("Roll: " + current.roll + ", Name: " + current.name + ", Age: " +
                    current.age + ", Grade: " + current.grade);
            current = current.next;
        }
        System.out.println();
    }
}

public class StudentLinkedListDemo {
    public static void main(String[] args) {
        StudentLinkedList sll = new StudentLinkedList();

        sll.addAtEnd(1, "Alice", 20, "A");
        sll.addAtBeginning(2, "Bob", 21, "B");
        sll.addAtPosition(2, 3, "Charlie", 22, "C");

        sll.displayAll();

        sll.searchByRoll(3);
        sll.updateGrade(3, "A+");

        sll.deleteByRoll(2);
        sll.displayAll();
    }
}
