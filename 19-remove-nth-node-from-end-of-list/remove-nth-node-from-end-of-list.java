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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode tmp = head;
        while(tmp!=null){
            size++;
            tmp = tmp.next;
        }

        int fsize = size-n;
        if(fsize==0){
            return head.next;
        }

        ListNode prev = head;
        ListNode cur = head;
        
        while(fsize!=0){
            
            prev = cur;
            cur = cur.next;
            fsize--;
        }

        prev.next = cur.next;
        return head;
    }
}