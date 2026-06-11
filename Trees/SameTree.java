//Problem : Same Tree

//Appraoch 1 : Recursive DFS
//Time Complexity : O(n) 
//Space Complexity : O(h) → recursion stack (h = height of tree)


// Link :
// https://leetcode.com/problems/same-tree/description/

/*
Idea

Compare nodes recursively:

If both are null → same
If one is null → not same
If values differ → not same
Recursively compare left and right subtrees

This is the standard recursive DFS solution.
*/


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}


public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // one node is null
        if (p == null || q == null) {
            return false;
        }

        // values are different
        if (p.val != q.val) {
            return false;
        }

        // compare left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        // Tree 1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = isSameTree(p, q);

        System.out.println(result);
    }
}



//Appraoch 2 : Iterative BFS Using Queue
//Time Complexity : O(n) 
//Space Complexity : O(n) 

/*
Idea

Use a queue to compare nodes level by level.

This avoids recursion stack overflow for very deep trees.
*/

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {

            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // both are null
            if (node1 == null && node2 == null) {
                continue;
            }

            // one is null
            if (node1 == null || node2 == null) {
                return false;
            }

            // values differ
            if (node1.val != node2.val) {
                return false;
            }

            // add left children
            queue.offer(node1.left);
            queue.offer(node2.left);

            // add right children
            queue.offer(node1.right);
            queue.offer(node2.right);
        }

        return true;
    }

    public static void main(String[] args) {

        // Tree 1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = isSameTree(p, q);

        System.out.println(result);
    }
}
