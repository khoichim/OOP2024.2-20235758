package JavaBasics;
import java.util.Arrays;
import java.util.Scanner;
public class bai6_5 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] my_array1 = new int[n];
        System.out.println("Enter " + n + " integer values:");
        for (int i = 0; i < n; i++) {
            my_array1[i] = scanner.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(my_array1));
        Arrays.sort(my_array1);
        System.out.println("Sorted array: " + Arrays.toString(my_array1));
        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average value: " + average);
        scanner.close(); 
    }
}
