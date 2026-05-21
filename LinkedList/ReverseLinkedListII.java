//Problem : Reverse Linked List II
//Approach : In-Place Reversal
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
The idea is:

  1. Reach the node just before position left
  2. Reverse the sublist normally
  3. Reconnect the reversed portion back to the original list

  Step-by-Step Approach :

  1. Create a dummy node pointing to head.
  2. Move to the node just before the left position.
  3. Keep another pointer at the left position (start of sublist).
  4. Store the start node of the sublist because it becomes the tail after reversal.
  5. Reverse the nodes from left to right using normal linked list reversal.
  6. After reversal:
    - Previous pointer becomes the new head of reversed sublist
    - Current pointer points to the node after the reversed part
  7. Connect the node before sublist to the new reversed head.
  8. Connect the tail of reversed sublist to the remaining list.
  9. Return the updated head using dummy node.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedListII {

    // Optimal Solution
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move to node before left position
        ListNode leftPre = dummy;
        ListNode currNode = head;

        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        // Reverse sublist
        ListNode subListHead = currNode;
        ListNode preNode = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currNode.next;

            currNode.next = preNode;

            preNode = currNode;
            currNode = nextNode;
        }

        // Reconnect reversed part
        leftPre.next = preNode;
        subListHead.next = currNode;

        return dummy.next;
    }

    // Utility method to print linked list
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

        int left = 2;
        int right = 4;

        head = reverseBetween(head, left, right);

        System.out.println("Reversed List:");
        printList(head);
    }
}
