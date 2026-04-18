//Problem : Majority Element
//Approach : Boyer-Moore Voting Algorithm for Optimal Solution 
//Time complexity : O(n)
//Space complexity : O(1)

import java.util.Scanner;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find majority element
        int result = majorityElement(nums);

        // Output result
        System.out.println("Majority Element: " + result);

        sc.close();
    }
}

/*
sample input :
7
2 2 1 1 1 2 2
*/

/*
Core Intuition :

  Think of it like votes:
    ->Majority element has more than half votes
    ->Every time we see a different element, we cancel one vote
    ->Since majority is more than all others combined, it survives
*/
