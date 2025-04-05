package DataStructures.LinkedLists;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode current = null; // For view and move
  
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        System.out.println("Added task at beginning: " + taskName);
    }

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Added task at end: " + taskName);
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 1 || head == null) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode current = head;
        int count = 1;

        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }

        System.out.println("Added task at position " + position + ": " + taskName);
    }

    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        TaskNode current = head;
        TaskNode prev = tail;
        boolean found = false;

        do {
            if (current.taskId == taskId) {
                found = true;
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = prev;
                }
                System.out.println("Removed task with ID: " + taskId);
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) System.out.println("Task ID not found: " + taskId);
    }

    public void viewCurrentTaskAndMoveNext() {
        if (current == null) {
            current = head;
        }

        if (current != null) {
            System.out.println("Current Task:");
            printTask(current);
            current = current.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("All Tasks:");
        TaskNode temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks with priority " + priority);
        }
    }

    private void printTask(TaskNode task) {
        System.out.println("ID: " + task.taskId + ", Name: " + task.taskName +
                ", Priority: " + task.priority + ", Due Date: " + task.dueDate);
    }
}

public class SchedulerCircular{
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, "Write report", 2, "2025-04-15");
        scheduler.addTaskAtBeginning(2, "Fix bugs", 1, "2025-04-12");
        scheduler.addTaskAtPosition(3, "Email client", 3, "2025-04-13", 2);
        scheduler.displayAllTasks();

        scheduler.viewCurrentTaskAndMoveNext(); // View 1
        scheduler.viewCurrentTaskAndMoveNext(); // View 2
        scheduler.viewCurrentTaskAndMoveNext(); // View 3
        scheduler.viewCurrentTaskAndMoveNext(); // Cycles back to 1

        scheduler.searchByPriority(1);

        scheduler.removeTaskById(3);
        scheduler.displayAllTasks();
    }
}
