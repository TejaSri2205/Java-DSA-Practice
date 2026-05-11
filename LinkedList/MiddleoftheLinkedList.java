//Problem : Middle of the Linked List
//Approach : Hare and Tortoise algorithm for optimal solution.
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea

Use two pointers:

slow moves one step at a time.
fast moves two steps at a time.

When fast reaches the end:

slow will be at the middle.

This is the most efficient and standard interview solution.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MiddleoftheLinkedList {

    // Optimal Solution
    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // slow moves 1 step
        // fast moves 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        // Creating Linked List:
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = middleNode(head);

        System.out.println("Middle Node Value: " + middle.val);
    }
}
