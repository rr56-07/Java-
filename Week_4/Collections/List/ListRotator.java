import java.util.ArrayList;
import java.util.List;

public class ListRotator {

    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        List<T> rotatedList = new ArrayList<>();
        
        for (int i = positions; i < size; i++) {
            rotatedList.add(list.get(i));
        }
        
        for (int i = 0; i < positions; i++) {
            rotatedList.add(list.get(i));
        }
        
        list.clear();
        list.addAll(rotatedList);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("Original List: " + numbers);
        rotateList(numbers, 2);
        System.out.println("List after rotation by 2: " + numbers);
    }
}
