//Problem : Add Two Numbers
//Approach : Digit-by-Digit Addition Using Carry (Elementary Math Simulation)
//Time Complexity : O(max(n,m))
//Space Complexity : O(max(n,m))

/*
Idea :
Simulate elementary school addition digit by digit.

At every step:
  - Add current digits from both lists
  - Add carry
  - Store (sum % 10) in new node
  - Update carry as (sum / 10)


*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);

            curr = curr.next;
        }

        return dummy.next;
    }
}
