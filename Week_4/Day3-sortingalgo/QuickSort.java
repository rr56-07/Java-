package sortingalgo;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(double[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    public static int partition(double[] a, int low, int high) {
        double pivot = a[low];
        int i = low, j = low;
        for (i = low+1; i <= high; i++) {
            if (a[i] <= pivot) {
                double temp = a[j+1];
                a[j+1] = a[i];
                a[i] = temp;
                j++;
            }
        }
        double temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        double[] array = {1299.99, 499.50, 799.00, 299.99, 999.99};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    
}
