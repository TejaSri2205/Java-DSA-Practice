//Problem : Remove Linked List Elements
//Approach : Iterative Traversal with Dummy Node
//Time Complexity : O(n)
//Space Complexity : O(1)

/*
Idea
  Traverse the linked list and directly remove nodes:
    - Use a dummy node to handle deletion at the head.
    - If curr.next.val == val, skip the node.
    
Why Dummy Node?
  -> It simplifies edge cases where the head itself must be removed.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveLinkedListElements {

    // Better Approach
    public static ListNode removeElements(ListNode head, int val) {

        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {

            if (curr.next.val == val) {
                // Remove node
                curr.next = curr.next.next;
            } else {
                // Move forward
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    // Function to print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Creating linked list:
        // 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int val = 6;

        System.out.println("Original List:");
        printList(head);

        head = removeElements(head, val);

        System.out.println("After Removing " + val + ":");
        printList(head);
    }
}
