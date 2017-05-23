/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0), ans = list;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val ){
                list.next = l1;
                list = list.next;
                l1 = l1.next;
            }else{
                list.next = l2;
                list = list.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) list.next = l1;
        if(l2 != null) list.next = l2;
        return ans.next;
    }
}