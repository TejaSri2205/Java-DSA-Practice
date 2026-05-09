//Problem : Linked List Cycle
//Approach : Floyd-Warshall algorithm
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea

Use two pointers:

slow moves one step
fast moves two steps

If there is a cycle, both pointers will eventually meet.

If fast reaches null, there is no cycle.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    // Function to detect cycle
    public boolean hasCycle(ListNode head) {

        // Edge case
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {

            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            // If both meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Main method for testing
    public static void main(String[] args) {

        Solution sol = new Solution();

        // Creating linked list:
        // 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // Creating cycle:
        // -4 points back to node with value 2
        fourth.next = second;

        // Check cycle
        boolean result = sol.hasCycle(head);

        System.out.println("Cycle exists: " + result);
    }
}
