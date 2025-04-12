package linearandbinary;

public class RotationPoint {
    public static void main(String[] args) {
        int[] rotatedArray = {6, 7, 9, 15, 19, 2, 3};
        int rotationPoint = findRotationPoint(rotatedArray);
        System.out.println("Rotation point: " + rotationPoint);
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return arr[left];
    }
}
