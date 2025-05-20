import java.util.LinkedList;

public class NthElementFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        if (list == null || list.size() < N) {
            return null;
        }

        T result = null;
        LinkedList<T> fastPointer = new LinkedList<>();
        LinkedList<T> slowPointer = new LinkedList<>();

        for (T element : list) {
            fastPointer.add(element);
        }

        while (fastPointer.size() > N) {
            fastPointer.poll();
        }
        while (fastPointer.size() > 0) {
            slowPointer.add(fastPointer.poll());
        }

        return slowPointer.peek();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        String nthElement = findNthFromEnd(list, 2);
        System.out.println("Nth Element from the End: " + nthElement);
    }
}
