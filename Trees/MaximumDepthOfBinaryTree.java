// Problem : Maximum Depth Of Binary Tree
// Appraoch : Recursive DFS
// Time Complexity : O(N)
// Space Complexity : O(H) (recursive stack)
//                    O(log N) for balanced tree
//                    O(N) for skewed tree

// Link :
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

/*
Idea

The depth of a node is:

Depth(node)=1+max(Depth(left),Depth(right))

Compute the depth of left and right subtrees recursively and return the larger one.

Algorithm
1. If node is null, return 0.
2. Recursively find left depth.
3. Recursively find right depth.
4. Return 1 + max(leftDepth, rightDepth).

*/

public class MaximumDepthOfBinaryTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Solution class
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {

        /*
                3
               / \
              9  20
                 / \
                15  7

            Maximum Depth = 3
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();

        int depth = solution.maxDepth(root);

        System.out.println("Maximum Depth: " + depth);
    }
}

/*
Dry Run

The recursion computes:

maxDepth(15) = 1
maxDepth(7)  = 1

maxDepth(20) = 1 + max(1,1) = 2

maxDepth(9)  = 1

maxDepth(3)  = 1 + max(1,2) = 3

So the answer is 3.
*/
