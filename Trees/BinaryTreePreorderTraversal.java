//Problem : Binary Tree Preorder Traversal

// Link :
// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

//Approach 1 : Recursive DFS (Brute Force)
//Time Complexity : O(n)
//Space Complexity : O(n)(recursive call stack in worst case)

/*
Idea :

Use recursion:
  - Visit root
  - Traverse left subtree
  - Traverse right subtree

This is the most straightforward solution.
*/


import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePreorderTraversal {

    // Recursive preorder traversal
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        preorder(root, ans);

        return ans;
    }

    private static void preorder(TreeNode node, List<Integer> ans) {

        if (node == null) {
            return;
        }

        ans.add(node.val);          // Root
        preorder(node.left, ans);   // Left
        preorder(node.right, ans);  // Right
    }

    public static void main(String[] args) {

        /*
                1
                 \
                  2
                 /
                3
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(root);

        System.out.println(result);
    }
}



//Approach 2 : Iterative Using Stack (Better)
//Time Complexity : O(n)
//Space Complexity : O(n)(stack can contain nodes)

/*
Idea :

Use a stack to simulate recursion.

Steps:
  1. Push root into stack
  2. Pop node
  3. Add node value
  4. Push right child first
  5. Push left child second

Why right first?
Because stack is LIFO, so left gets processed before right.
*/


import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePreorderTraversal {

    // Iterative preorder traversal
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            ans.add(node.val);

            // Push right first
            if (node.right != null) {
                stack.push(node.right);
            }

            // Push left second
            if (node.left != null) {
                stack.push(node.left);
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
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(root);

        System.out.println(result);
    }
}




//Approach 3 : Morris Traversal (Optimal)
//Time Complexity : O(n)
//Space Complexity : O(1)

/*
Idea : 

Morris Traversal performs preorder traversal using O(1) extra space.

It creates temporary threaded links in the tree.

Core Concept =>
For every node:
- If left child is null:
      - visit node
      - move right
- Otherwise:
      - find inorder predecessor
      - create temporary thread
      - move left
*/


import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePreorderTraversal {

    // Morris preorder traversal
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // If left child is null
            if (curr.left == null) {

                ans.add(curr.val);
                curr = curr.right;
            }
            else {

                // Find predecessor
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // Create thread
                if (pred.right == null) {

                    ans.add(curr.val);

                    pred.right = curr;
                    curr = curr.left;
                }
                // Remove thread
                else {

                    pred.right = null;
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
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(root);

        System.out.println(result);
    }
}


