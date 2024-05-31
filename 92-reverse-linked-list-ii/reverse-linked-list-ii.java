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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head, prev = null;
        left--;
        right--;
        for (int i = 0; i < left; i++) {
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = reverseList(node, right - left + 1);
        else
            head = reverseList(node, right - left + 1);
        return head;
    }

    private ListNode reverseList(ListNode A, int count) {
        if (A == null)
            return null;
        ListNode node = A, prev = null, next;
        while (node != null && count > 0) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            count--;
        }
        A.next = node;
        return prev;
    }
}