//Problem : Binary Tree Inorder Traversal

//Appraoch 1 : Recursive Traversal (Brute Force)
//Time Complexity : O(n) → every node visited once
//Space Complexity : O(h) → recursion stack height
//                    Worst case: O(n) for skewed tree

/*
This is the most straightforward approach using recursion.

Idea
  - Traverse left subtree
  - Visit current node
  - Traverse right subtree
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        inorder(root, ans);

        return ans;
    }

    private static void inorder(TreeNode node, List<Integer> ans) {

        if (node == null) {
            return;
        }

        inorder(node.left, ans);

        ans.add(node.val);

        inorder(node.right, ans);
    }

    public static void main(String[] args) {

        /*
                 1
                  \
                   2
                  /
                 3

            Inorder: [1, 3, 2]
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);

        System.out.println(result);
    }
}

//Appraoch 2 : Iterative using Stack (Better Appraoch)
//Time Complexity : O(n)
//Space Complexity : O(n) in worst case

/*
Instead of recursion, we simulate recursion using a stack.

Idea :

1. Keep going left and push nodes into stack

2. When left becomes null:
    - pop from stack
    - add node value
    - move to right subtree
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Traverse left subtree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process node
            curr = stack.pop();

            ans.add(curr.val);

            // Move to right subtree
            curr = curr.right;
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                 1
                  \
                   2
                  /
                 3

            Inorder: [1, 3, 2]
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);

        System.out.println(result);
    }
}

//Appraoch 3 : Morris Traversal (optimal Approach)
//Time Complexity : O(n)
//Space Complexity : O(1)

/*
This is the most optimized approach because it uses O(1) extra space.

Idea :

We create temporary links (threads) to return back to parent nodes without using stack or recursion.

Steps

For every node:

1. If left child is null:
    - visit node
    - move right
2. Else:
    - find inorder predecessor
    - create temporary thread
    - move left
3. If thread already exists:
    - remove thread
    - visit node
    - move right
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // If left child is null
            if (curr.left == null) {

                ans.add(curr.val);

                curr = curr.right;
            }
            else {

                // Find inorder predecessor
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // Create temporary link
                if (prev.right == null) {

                    prev.right = curr;

                    curr = curr.left;
                }
                else {

                    // Remove temporary link
                    prev.right = null;

                    ans.add(curr.val);

                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                 1
                  \
                   2
                  /
                 3

            Inorder: [1, 3, 2]
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);

        System.out.println(result);
    }
}
