//Problem : Find the Duplicate Number
//Approach : Floyd’s Cycle Detection - Tortoise & Hare for optimal solution
//Time complexity : O(n)
//Space complexity : O(1)

public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        // Phase 1: Detect intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];           // move 1 step
            fast = nums[nums[fast]];     // move 2 steps
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // duplicate number
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        int duplicate = findDuplicate(nums);

        System.out.println("Duplicate number: " + duplicate);
    }
}

/*
Core Idea (1-line memory hook) : “Treat array as a linked list → duplicate creates a cycle → find cycle entry using Floyd’s algorithm.”

Algorithm in 2 Phases

🐢 Phase 1: Detect Cycle
- Slow → 1 step
- Fast → 2 steps
- They must meet inside the cycle

🎯 Phase 2: Find Cycle Start
- Reset slow to start
- Move both 1 step
- Where they meet = duplicate

things to Notice :
- First meeting point is inside the cycle, not necessarily the answer
- Resetting one pointer aligns distances
- Second meeting point = cycle entry = duplicate
*/
