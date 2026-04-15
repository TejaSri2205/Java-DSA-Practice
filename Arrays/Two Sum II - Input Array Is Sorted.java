//Problem : Two Sum II - Input Array Is Sorted
//Approach : Two Pointers for optimal solution
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class Two_Sum_II {
    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++;  //move forward to increase sum
            } else {
                right--;  //move backward to decrease sum
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum2(numbers, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
