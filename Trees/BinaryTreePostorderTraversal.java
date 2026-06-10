//Problem : Binary Tree Postorder Traversal

// Link :
// https://leetcode.com/problems/binary-tree-postorder-traversal/description/

//Appraoch 1 : Recursive Traversal (Brute Force)
//Time Complexity : O(n) → every node visited once
//Space Complexity : O(h) → recursion stack (h = height of tree)

/*
Idea

Use recursion:
  1. Traverse left subtree
  2. Traverse right subtree
  3. Add current node
*/


import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePostorderTraversal {

    // Postorder Traversal: Left Right Root
    public static void postorder(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        postorder(node.left, result);

        postorder(node.right, result);

        result.add(node.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5

        Postorder = [4, 5, 2, 3, 1]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> ans = postorderTraversal(root);

        System.out.println(ans);
    }
}




//Appraoch 2 : Using Two Stack (Better Appraoch)
//Time Complexity : O(n)
//Space Complexity : O(n) 

/*
Idea :

Postorder = Left Right Root

Modified preorder:
  - Root Right Left
Then reverse it:
  - Left Right Root
We use:
  - Stack1 → traversal
  - Stack2 → reverse order storage
*/


import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            TreeNode current = stack1.pop();

            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5

        Postorder = [4, 5, 2, 3, 1]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> ans = postorderTraversal(root);

        System.out.println(ans);
    }
}

//Appraoch 3 : Using One Stack (optimal Approach)
//Time Complexity : O(n)
//Space Complexity : O(h)

/*
Idea :

Use a single stack and track traversal carefully.

We:
  1. Move left as much as possible
  2. Check right subtree
  3. Process node only when both children are done
This avoids using two stacks.
*/


import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {

            // Move to leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode peekNode = stack.peek();

            // Visit right subtree if not visited
            if (peekNode.right != null && lastVisited != peekNode.right) {

                current = peekNode.right;

            } else {

                result.add(peekNode.val);

                lastVisited = stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5

        Postorder = [4, 5, 2, 3, 1]
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> ans = postorderTraversal(root);

        System.out.println(ans);
    }
}


