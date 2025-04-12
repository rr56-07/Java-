package linearandbinary;

public class CompareStringBufferStringBuilder {
    public static void main(String[] args) {
        int iterations = 1000000; 
        String str = "hello";
        long startTimeBuffer = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        long startTimeBuilder = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append(str);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " nanoseconds");
    }
}
