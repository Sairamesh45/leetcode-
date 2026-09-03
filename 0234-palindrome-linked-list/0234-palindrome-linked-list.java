/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null &&  fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;

        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode a = head;
        ListNode b = prev;

        while(b != null)
        {
            if(a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }

        return true;
    }
}