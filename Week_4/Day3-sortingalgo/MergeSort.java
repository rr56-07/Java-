package sortingalgo;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(double[] a, int l, int h) {
        if (l < h) {
            int mid = l + (h-l) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, h);
            merge(a, l, mid, h);
        }
    }

    public static void merge(double[] a, int l, int mid, int h) {
        double[] temp = new double[h-l+1];
        int i = l, j = mid +1 , k = 0;

        while (i <= k && j <= h) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }

        while (i<mid){
            temp[k++]=a[i++];
        }

        while (j<h){
            temp[k++]=a[j++];

        }

        for (int o = 0; o<temp.length;o++){
            a[l++]=temp[o];
        }
    }

    public static void main(String[] args) {
        double[] array = {499.99, 299.50, 799.75, 199.90, 599.00};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    } 
}
