// Problem : Balanced Binary Tree
// Approach : Single DFS with Early Termination
// Time Complexity :
// Space Complexity :

// link :
// https://leetcode.com/problems/balanced-binary-tree/description/

/*
Idea

While computing height, immediately return -1 if a subtree is unbalanced.

For each node:
1. Get left subtree height.
      If -1, propagate -1.
2. Get right subtree height.
      If -1, propagate -1.
3. If difference > 1, return -1.
4. Otherwise return actual height.

Finally:
    Tree is balanced if returned value is not -1.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        // Balanced Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println("Balanced Tree: " + isBalanced(root1));

        // Unbalanced Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        System.out.println("Unbalanced Tree: " + isBalanced(root2));
    }
}
