/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet();

        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(!set.contains(headB) && headB != null){
            headB = headB.next;
        }
        return headB;
    }
}