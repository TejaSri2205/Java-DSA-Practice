//Problem : Sort colors
//Approach : Dutch National Flag Algorithm for optimal solution
//Time Complexity : O(n)
//Space Complexity :  O(1)

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        // Print sorted array
        System.out.print("Sorted array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

/*
Idea:

Use three pointers:
  -low → boundary for 0s
  -mid → current element
  -high → boundary for 2s

Logic:
If nums[mid] == 0 → swap with low, move both
If nums[mid] == 1 → move mid
If nums[mid] == 2 → swap with high, move high

*/
