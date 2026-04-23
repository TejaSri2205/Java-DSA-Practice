//problem : Missing number

/* 
Approach 1: Sum Formula
Idea :
  -Use formula for sum of first n natural numbers
  -Compute expected sum and subtract actual sum.

Complexity :
Time: O(n)
Space: O(1) 
*/

//  /*
import java.util.Scanner;

public class MissingNumberSum {

    public static int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter elements (distinct numbers from 0 to n with one missing):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = missingNumber(nums);

        System.out.println("Missing Number: " + result);

        sc.close();
    }
}
//  */

/*
Approach 2: XOR
Idea :
  Use XOR properties:
    a ^ a = 0
    a ^ 0 = a

Complexity :
Time: O(n)
Space: O(1) 
*/

// /*
import java.util.Scanner;

public class MissingNumberXOR {

    public static int missingNumber(int[] nums) {
        int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter elements (distinct numbers from 0 to n with one missing):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = missingNumber(nums);

        System.out.println("Missing Number: " + result);

        sc.close();
    }
}
// */
