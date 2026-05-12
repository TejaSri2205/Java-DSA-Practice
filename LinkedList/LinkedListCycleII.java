//Problem : Linked List Cycle II
//Approach : Floyd-Warshall algorithm
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea

Use:
  Slow pointer → moves 1 step
  Fast pointer → moves 2 steps

If cycle exists:
  slow and fast will meet.

Then:
  1. Move one pointer to head.
  2. Move both one step at a time.
  3. The point where they meet again is the start of the cycle.

  
Mathematical Intuition
Suppose:
  Distance from head to cycle start = x
  Distance from cycle start to meeting point = y
  Cycle length = c

When slow and fast meet:
    2(x + y) = x + y + n*c

Simplifies to:
    x = n*c - y

Which means:
  One pointer from head
  One pointer from meeting point

moving one step at a time will meet at the cycle start.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleII {

    // Optimal Solution using Floyd's Cycle Detection
    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                // Step 2: Find cycle starting node
                ListNode entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }

                return entry;
            }
        }

        // No cycle
        return null;
    }

    public static void main(String[] args) {

        // Creating linked list:
        // 3 -> 2 -> 0 -> -4
        //      ^         |
        //      |_________|

        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // Creating cycle
        fourth.next = second;

        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
