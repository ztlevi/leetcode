/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	    public ListNode oddEvenList(ListNode head) {
	        ListNode tailList = new ListNode(0), tail = tailList;
	        ListNode ans = head; ListNode foo = new ListNode(0);
	        while(head != null && head.next != null){
	            tailList.next = new ListNode(head.next.val);
	            tailList = tailList.next;
	            head.next = head.next.next;
	            foo = head;
	            head = head.next;
	        }
	        if(head == null){
	            foo.next = tail.next;
	        }else if(head.next == null){
	            head.next = tail.next;
	        }

	        return ans;
	    }
}