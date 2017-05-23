/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        List<ListNode> list = new ArrayList();
        list.addAll(Arrays.asList(lists));
        while (list.size() > 1) {
            List<ListNode> newList = new ArrayList();
            for (int i = 0; i < list.size()-1; i += 2) {
                ListNode mergedList = merge2Lists(list.get(i), list.get(i+1));
                newList.add(mergedList);
            }
            if (list.size() % 2 == 1) 
                newList.add(list.get(list.size()-1));
            list = newList;
        } 
        return list.get(0);
    }
    
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0), dummy = current;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
                current = current.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
                current = current.next;
            }
        }
        if (l1 != null) current.next = l1;
        else current.next = l2;
        
        return dummy.next;
    }
}