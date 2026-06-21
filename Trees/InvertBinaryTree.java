//Problem : Invert Binary Tree
//Approach : Recursive In-Place Swap
//Time Complexity :
//space Complexity :

// Link :
// https://leetcode.com/problems/invert-binary-tree/description/

/*
Idea

For every node:

1. Swap left and right child.
2. Recursively invert left subtree.
3. Recursively invert right subtree.

This modifies the original tree directly.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // Inorder Traversal
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                 4
               /   \
              2     7
             / \   / \
            1   3 6   9
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Before Inversion (Inorder): ");
        inorder(root);
        System.out.println();

        invertTree(root);

        System.out.print("After Inversion (Inorder): ");
        inorder(root);
        System.out.println();
    }
}
