//Problem : Reverse Linked List
//Approach : Iterative Pointer Reversal
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea :

Reverse links using three pointers:
  prev
  curr
  next

At each step:
    1.Save next node
    2.Reverse current node link
    3.Move pointers forward

This is the most efficient solution.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReversedLinkedList {

    // Optimal Solution: Iterative Approach
    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode nextNode = curr.next;

            // Reverse the link
            curr.next = prev;

            // Move pointers forward
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    // Function to print linked list
    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating linked list:
        // 1 -> 2 -> 3 -> 4 -> 5 -> null

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(reversedHead);
    }
}
