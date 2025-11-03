package problemSolving;

import java.util.PriorityQueue;

import static problemSolving.LeetCode21MergeNode.mergeTwoLists;

public class LeetCode23MergeKShortedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val , ListNode next) {this.val = val; this.next = next;}

    }
    public static ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode>pq = new PriorityQueue<>(
                (a,b)-> Integer.compare(a.val , b.val)
        );
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }
        ListNode result = null;
        ListNode resultEnd = null;
        while (!pq.isEmpty()){
            ListNode smallest = pq.poll();
            if(result == null){
                result = smallest;
            }
            else{
                resultEnd.next = smallest;
            }
            resultEnd = smallest;
            if(smallest.next != null){
                pq.add(smallest.next);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        // Create first sorted list: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // Create second sorted list: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Create third sorted list: 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode merged = mergeKLists(lists);

        // Print merged list
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
