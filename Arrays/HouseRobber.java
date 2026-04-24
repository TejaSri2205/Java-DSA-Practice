//Problem : House Robber 
//Approach : Bottom-Up DP + Space Optimization for optimal solution
//Time Complexity : O(n)
//Space Complexity : O(1)

import java.util.*;

public class HouseRobber {

    public static int rob(int[] nums) {
        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format:
        // First line: n (number of houses)
        // Second line: n space-separated integers
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = rob(nums);
        System.out.println(result);

        sc.close();
    }
}

/*
Sample input :

5
2 7 9 3 1
*/

/*
How it works (quick intuition) :
    -prev1 = max money up to previous house
    -prev2 = max money up to house before previous
    -At each step:
        current = max(skip current house, rob current house)
*/
