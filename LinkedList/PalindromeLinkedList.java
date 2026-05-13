//Problem : Palindrome Linked List
//Approach : Reverse Second Half
//Time Complexity : O(N)
//Space Complexity : O(1)

/*
Idea
Find middle of linked list using slow & fast pointers.
Reverse second half of linked list.
Compare first half and reversed second half.
(Optional) Restore original list.

This is the most asked interview approach.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        // Empty list or single node
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare both halves
        ListNode firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Function to reverse linked list
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode nextNode = current.next;

            current.next = prev;

            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // Main method for testing
    public static void main(String[] args) {

        Solution sol = new Solution();

        // Create linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = sol.isPalindrome(head);

        System.out.println("Is Palindrome: " + result);
    }
}
