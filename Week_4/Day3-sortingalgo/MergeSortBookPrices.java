package sortingalgo;
import java.util.*;

public class MergeSortBookPrices {

    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; i++) L[i] = prices[left + i];
        for (int j = 0; j < n2; j++) R[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) prices[k++] = L[i++];
            else prices[k++] = R[j++];
        }

        while (i < n1) prices[k++] = L[i++];
        while (j < n2) prices[k++] = R[j++];
    }

    public static void main(String[] args) {
        double[] bookPrices = {499.99, 299.50, 799.75, 199.90, 599.00};
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        System.out.println(Arrays.toString(bookPrices));
    }
}
