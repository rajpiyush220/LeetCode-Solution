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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                ListNode remove = temp;
                while (remove != null && remove.val == temp.val) remove = remove.next;
                temp = remove;
            } else {
                current.next = new ListNode(temp.val);
                temp = temp.next;
                current = current.next;
            }
        }
        return dummy.next;
        
    }
}