package runtimeAnalysis;

import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureComparison {

    public static void main(String[] args) {
        int size = 1000000;  // Adjust the dataset size for comparison

        // Sample dataset (use numbers from 0 to size-1)
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }

        // Measure Array search time
        long arrayStartTime = System.nanoTime();
        int target = size - 1;  // Searching for the last element
        boolean arrayFound = arraySearch(data, target);
        long arrayEndTime = System.nanoTime();
        long arraySearchTime = arrayEndTime - arrayStartTime;

        // Measure HashSet search time
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : data) {
            hashSet.add(num);
        }
        long hashSetStartTime = System.nanoTime();
        boolean hashSetFound = hashSet.contains(target);
        long hashSetEndTime = System.nanoTime();
        long hashSetSearchTime = hashSetEndTime - hashSetStartTime;

        // Measure TreeSet search time
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : data) {
            treeSet.add(num);
        }
        long treeSetStartTime = System.nanoTime();
        boolean treeSetFound = treeSet.contains(target);
        long treeSetEndTime = System.nanoTime();
        long treeSetSearchTime = treeSetEndTime - treeSetStartTime;

        // Output the results
        System.out.println("Array Search Time: " + arraySearchTime / 1000000.0 + " ms");
        System.out.println("HashSet Search Time: " + hashSetSearchTime / 1000000.0 + " ms");
        System.out.println("TreeSet Search Time: " + treeSetSearchTime / 1000000.0 + " ms");

        // Optionally print whether the target was found (for verification)
        System.out.println("Array Found: " + arrayFound);
        System.out.println("HashSet Found: " + hashSetFound);
        System.out.println("TreeSet Found: " + treeSetFound);
    }

    // Linear search in an array (O(N))
    public static boolean arraySearch(Integer[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
