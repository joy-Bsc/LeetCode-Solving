package problemSolving;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3217 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode modifiedList(int[] nums, ListNode head){
        Set<Integer>toDelete = new HashSet<>();
        for(int num : nums){
            toDelete.add(num);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null){
            if(toDelete.contains(current.next.val)){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        return  dummy.next;
    }

    public static void main(String[] args) {
        LeetCode3217Copy sol = new LeetCode3217Copy();

        // Create linked list: [1,2,3,4,5]
        LeetCode3217Copy.ListNode head = new LeetCode3217Copy.ListNode(1);
        head.next = new LeetCode3217Copy.ListNode(2);
        head.next.next = new LeetCode3217Copy.ListNode(3);
        head.next.next.next = new LeetCode3217Copy.ListNode(4);
        head.next.next.next.next = new LeetCode3217Copy.ListNode(5);

        int[] nums = {1, 2, 3};

        LeetCode3217Copy.ListNode result = sol.deleteNodes(head, nums);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
