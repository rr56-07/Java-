package linearandbinary;

public class LinearSearchFirstNegative {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, -1, 8, 10};
        
        int result = findFirstNegative(arr);
        
        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
        } else {
            System.out.println("No negative number found.");
        }
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
