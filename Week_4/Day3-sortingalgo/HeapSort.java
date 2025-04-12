package sortingalgo;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    public static void heapify(int[] arr, int p, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < p && arr[left] > arr[max]) {
            max = left;
        }

        if (right <p && arr[right] >arr[max]) {
            max= right;
        }

        if (max != i) {
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;
            heapify(arr, p, max);
        }
    }

    public static void main(String[] args) {
        int[] array = {55000, 48000, 67000, 39000, 72000, 51000};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
