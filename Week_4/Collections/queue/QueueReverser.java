package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReverser {

    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue.isEmpty()) {
            return;
        }

        T front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
