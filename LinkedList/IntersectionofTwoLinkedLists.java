//Problem : Intersection of Two Linked Lists

//Appraoch 1: Length Difference Method
//Time Complexity : O(m + n)
//Space Complexity : O(1)

/*
Idea

1.Find length of both linked lists.
2.Calculate difference:
    diff = abs(lenA - lenB)
3.Move pointer of longer list by diff nodes.
4.Now both pointers have equal remaining distance to travel.
5.Move both pointers together:
    headA = headA.next
    headB = headB.next
6.First node where:
    headA == headB
  is the intersection node.
7.If both become null, no intersection exists.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class IntersectionofTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Move longer list ahead
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Move both together
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private static int getLength(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static void main(String[] args) {

        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}

//Appraoch 2: Two Pointer Switching Method
//Time Complexity : O(m + n)
//Space Complexity : O(1)

/*
Idea

Use two pointers:

Pointer a starts at headA
Pointer b starts at headB

When a pointer reaches the end, redirect it to the other list’s head.

Why this works:

Both pointers travel exactly m + n steps
They align automatically at the intersection point

If no intersection exists, both become null.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class IntersectionofTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {

        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
