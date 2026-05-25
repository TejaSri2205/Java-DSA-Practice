//Problem : Maximum Subarray
//Approach : Kadane’s Algorithm
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea

If the current sum becomes negative, discard it because it will only reduce the future subarray sum.

We maintain:

currentSum → current running subarray sum
maxSum → maximum sum found so far
*/

public class MaximumSubarray {

    // Function to find maximum subarray sum
    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            // Update maximum sum
            maxSum = Math.max(maxSum, currentSum);

            // Reset current sum if it becomes negative
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
