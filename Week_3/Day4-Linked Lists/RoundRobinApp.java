package DataStructures.LinkedLists;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head;
        int totalProcesses = countProcesses();

        System.out.println("Starting Round Robin Scheduling with Time Quantum = " + timeQuantum);
        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= execTime;
                time += execTime;

                // Update waiting time and turnaround time for all other active processes
                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    System.out.println("Process P" + current.pid + " completed at time " + time);
                    removeProcess(current.pid);
                    if (head == null) break;
                    current = current.next;
                } else {
                    current = current.next;
                }

                displayQueue();
            }
        }

        printAverageTimes(totalProcesses);
    }

    public void removeProcess(int pid) {
        if (head == null) return;

        Process current = head, prev = null;

        // Find process with pid
        do {
            if (current.pid == pid) {
                if (current == head && head.next == head) {
                    head = null;
                } else {
                    if (current == head) {
                        head = head.next;
                    }

                    // Find previous node
                    prev = head;
                    while (prev.next != current) {
                        prev = prev.next;
                    }
                    prev.next = current.next;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.\n");
            return;
        }

        Process temp = head;
        System.out.print("Current Queue: ");
        do {
            System.out.print("[P" + temp.pid + ", RT: " + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public void printAverageTimes(int totalProcesses) {
        double totalWaiting = 0;
        double totalTurnaround = 0;
        Process temp = head;

        System.out.println("\nProcess Summary:");
        for (int i = 0; i < totalProcesses; i++) {
            System.out.println("P" + (i + 1) + ": Waiting Time = " + temp.waitingTime + ", Turnaround Time = " + temp.turnaroundTime);
            totalWaiting += temp.waitingTime;
            totalTurnaround += temp.turnaroundTime;
            temp = temp.next;
        }

        System.out.printf("Average Waiting Time: %.2f\n", totalWaiting / totalProcesses);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaround / totalProcesses);
    }
}

public class RoundRobinApp {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Time Quantum = 4

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 6, 3);
        scheduler.addProcess(4, 8, 1);

        scheduler.simulateScheduling();
    }
}
