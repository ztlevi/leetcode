/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = findMiddle(head);
        ListNode second = mid.next;
        second = reverse(second);
        while (second != null) {
            if (head.val != second.val){
                return false;
            }else{
                head = head.next;
                second = second.next;
            }
        }
        return true;
    }
    
    public ListNode findMiddle(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode ans = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            head = head.next;
            temp.next = ans;
            ans = temp;
        }
        return ans;
    }
}