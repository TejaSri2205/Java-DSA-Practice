//problem : MoveZeroes 

/* 
Approach 1: Better (Shift Non-Zero Forward)
Idea :
Shift all non-zero elements to the front, then fill the rest with zeros.

Complexity :
Time: O(n)
Space: O(1) 
Downside: Overwrites values (extra writes)
*/

//  /*

public class MoveZeroesBetter {

    public static void moveZeroes(int[] nums) {
        int index = 0; // position to place next non-zero

        // Step 1: Move all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // Step 2: Fill remaining positions with zeros
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        // Print result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

//  */

/*
Approach 2: Optimal (Two Pointer Swap)
Idea :
  Use two pointers:
  i → scans array
  j → tracks position for next non-zero
Swap when needed.

Complexity :
Time: O(n)
Space: O(1) 
*/

//  /*

public class MoveZeroesOptimal {

    public static void moveZeroes(int[] nums) {
        int j = 0; // position for next non-zero element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap only when needed
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        // Print result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

// */

/*
Comparision of Approaches :
Better ->	Rewrites all elements (even correct ones)
Optimal	-> Moves only misplaced non-zero elements



The optimal approach minimizes swaps because:

1.It performs swaps only when a non-zero is out of place
2.Each non-zero element is moved at most once
3.It avoids redundant writes and unnecessary shifts
4.It achieves the minimum number of operations required to restore order
*/
