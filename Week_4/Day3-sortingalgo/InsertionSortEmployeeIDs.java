package sortingalgo;
import java.util.*;

public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {3,4,5,6,1};
        insertionSort(employeeIDs);
        System.out.println(Arrays.toString(employeeIDs));
    }
}
