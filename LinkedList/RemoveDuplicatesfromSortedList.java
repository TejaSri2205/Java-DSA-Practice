//Problem : Remove Duplicates from Sorted List
//Approach : In-Place for Sorted List
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea :

Since the list is already sorted:

  - Duplicates always appear adjacent
  - Compare current node with next node
  - Skip duplicate nodes directly

No extra space needed.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveDuplicatesfromSortedList {

    // Optimal Solution
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;

        while (temp != null && temp.next != null) {

            // If duplicate found
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
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

        // Creating linked list:
        // 1 -> 1 -> 2 -> 3 -> 3

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        head = deleteDuplicates(head);

        System.out.println("After Removing Duplicates:");
        printList(head);
    }
}
