package linearandbinary;

import java.util.Arrays;

public class LinearAndBinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missingPositive);

        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
