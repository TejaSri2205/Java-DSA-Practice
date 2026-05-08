//Problem : Merge Two Sorted Lists
//Approach : Iterative Merge
//Time Complexity : O(n + m)
//Space Complexity : O(1)

/*
Idea :
Use two pointers.
Compare nodes from both lists.
Attach the smaller node to the answer list.
Continue until one list becomes empty.
Attach the remaining nodes.

This avoids sorting.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    // Better Approach - Iterative Method
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
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

        // First linked list: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Second linked list: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Merge lists
        ListNode mergedHead = mergeTwoLists(list1, list2);

        // Print merged list
        System.out.println("Merged Linked List:");
        printList(mergedHead);
    }
}
