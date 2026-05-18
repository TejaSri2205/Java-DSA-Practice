//Problem : Swap Nodes in Pairs

//Approach 1 : Iterative Pointer Manipulation
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Core idea :
Instead of swapping values, we swap the actual nodes by changing their next pointers.

Step-by-step approach :
  - Use a dummy node before the head to simplify swapping.
  - Traverse the linked list in pairs using a prev pointer.
  - Pick two adjacent nodes:
      first
      second
  - Swap them by changing their next pointers.
  - Move prev to the end of the swapped pair.
  - Repeat until fewer than 2 nodes remain.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SwapNodesinPairs {

    // Better Approach: Iterative Pointer Manipulation
    public static ListNode swapPairs(ListNode head) {

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // Traverse in pairs
        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev forward
            prev = first;
        }

        return dummy.next;
    }

    // Print Linked List
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
        // 1 -> 2 -> 3 -> 4

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        head = swapPairs(head);

        System.out.println("After Swapping Pairs:");
        printList(head);
    }
}

//Approach 2 : Recursion 
//Time Complexity : O(N)
//Space Complexity : O(N) (recursion stack)

/*
Core Idea

  - Use recursion to solve the problem pair by pair.
  - Swap the first two nodes.
  - Recursively call the function for the remaining linked list.
  - Connect the swapped pair with the recursive result.
  - Return the second node as the new head after swapping.

*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SwapNodesinPairs {

    // Optimal Approach: Recursive
    public static ListNode swapPairs(ListNode head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        // Recursively swap remaining list
        first.next = swapPairs(second.next);

        // Swap current pair
        second.next = first;

        // Return new head
        return second;
    }

    // Print Linked List
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
        // 1 -> 2 -> 3 -> 4

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        head = swapPairs(head);

        System.out.println("After Swapping Pairs:");
        printList(head);
    }
}
