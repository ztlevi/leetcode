/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;   
        
        if(head.next != null) {
            ListNode rest = reverseList(head.next);
            head.next.next = head; //two next to switch the arrow's direction
            head.next = null;
            return rest;
        }else
            return head;

    }
}