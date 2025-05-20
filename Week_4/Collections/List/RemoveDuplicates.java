import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> result = new ArrayList<>();
        HashSet<T> seen = new HashSet<>();
        
        for (T element : list) {
            if (!seen.contains(element)) {
                result.add(element);
                seen.add(element);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("List after removing duplicates: " + uniqueNumbers);
    }
}
