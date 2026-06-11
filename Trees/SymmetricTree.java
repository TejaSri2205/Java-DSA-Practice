//Propblem : Symmetric Tree
//Time Complexity : O(n) 
//Space Complexity : O(h) → recursion stack (h = height of tree)

// Link :
// https://leetcode.com/problems/symmetric-tree/description/

/*
Idea

Two trees are mirrors if:

Their root values are equal.
Left child of first tree = Right child of second tree.
Right child of first tree = Left child of second tree.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }

        // One node is null
        if (left == null || right == null) {
            return false;
        }

        // Values don't match
        if (left.val != right.val) {
            return false;
        }

        // Check mirror condition
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     2
             / \   / \
            3   4 4   3

            Symmetric Tree
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root)); // true
    }
}
