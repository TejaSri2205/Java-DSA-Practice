//Problem : Remove Nth Node From End of List
//Apprach : Two pointers
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea

Use two pointers:
  fast
  slow

Steps:
  - Move fast pointer n steps ahead.
  - Move both pointers together until fast.next == null.
  - slow will point to the previous node of the target.
  - Delete the node.

A dummy node is used to handle edge cases cleanly.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNodeFromEndofList {

    // Function to remove nth node from end
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers together
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove target node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Function to print linked list
    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list:
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        int n = 2;

        head = removeNthFromEnd(head, n);

        System.out.println("After Removing " + n + "th Node From End:");
        printList(head);
    }
}
