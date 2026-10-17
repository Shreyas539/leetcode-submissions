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
    public void reorderList(ListNode head) {
        int n =0;
        ListNode tmp = head;
        ListNode l1 = head;
        while(tmp!=null){
            n++;
            tmp = tmp.next;
        }

        int mid = n/2;
        ListNode l2=head;

        while(mid!=0){
            l2 = l2.next;
            mid--;
        }
        ListNode prev = l2;
        l2 = l2.next;
        prev.next = null;

        l2 = reverse(l2);
        while(l2!=null && l1!=null){
            if(l1.next==null){
                l1.next = l2;
                break;
            }
            ListNode l1nxt = l1.next;
            ListNode l2nxt = l2.next;

            l1.next = l2;
            l2.next = l1nxt;
            l1 = l1nxt;
            l2 = l2nxt;

        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}