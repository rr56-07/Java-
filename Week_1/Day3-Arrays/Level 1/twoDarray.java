import java.util.Scanner; 

public class twoDarray {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.println("Enter no.of rows");
		int rows = input.nextInt();
		System.out.println("Enter no.of columns");
		int columns = input.nextInt();
		int[][] matrix = new int[rows][columns];
		for (int i=0; i<rows; i++) {
		    for (int j=0; j<columns; j++) {
			    matrix[i][j] = input.nextInt();
			}
		}
		int[] array = new int[rows*columns];
		int index = 0;
		for (int i=0; i<rows; i++) {
		    for (int j=0; j<columns;j++) {
			    array[index] = matrix[i][j];
				index++;
			}
		}
		System.out.println("Elements in the 1D array");
		for (int i=0; i<array.length; i++){
		    System.out.print(array[i]+" ");
		}
		input.close();
	}
}