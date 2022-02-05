/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // return partition(lists,0,lists.length-1);
        if (lists == null || lists.length == 0)
            return null;
        // PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.length,new
        // Comparator<ListNode>(){
        // @Override
        // public int compare(ListNode o1,ListNode o2){
        // if(o1.val< o2.val){
        // return -1;
        // }else if(o1.val==o2.val){
        // return 0;
        // }else{
        // return 1;
        // }
        // }
        // });

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public static ListNode partition(ListNode[] lists, int s, int e) {
        if (s == e)
            return lists[s];
        if (s < e) {
            int mid = (s + e) / 2;
            ListNode l1 = partition(lists, s, mid);
            ListNode l2 = partition(lists, mid + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}