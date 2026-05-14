//Problem : Odd Even Linked List
//Approach : Two Pointer Technique with In-place Linked List Manipulation
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea :
Rearrange links directly without extra space.

Maintain:
  - odd pointer
  - even pointer
  - evenHead to remember start of even list

Then:
  - connect odd nodes together
  - connect even nodes together
  - attach even list at end of odd list
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class OddEvenLinkedList {

    // Optimal Solution
    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            // Connect odd nodes
            odd.next = even.next;
            odd = odd.next;

            // Connect even nodes
            even.next = odd.next;
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHead;

        return head;
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
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        head = oddEvenList(head);

        System.out.println("After Odd-Even Rearrangement:");
        printList(head);
    }
}
