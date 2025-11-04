package problemSolving;

public class LeetCode2525ReverseNodesInKGroup {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true){
            ListNode kth = kthNode(curr, k);
            if(kth == null) break;

            ListNode nextGroupStart = kth.next;

            ListNode prev = null;
            ListNode node = curr;
            while (node != nextGroupStart){
                ListNode temp = node.next;
                node.next = prev;
                prev = node;
                node = temp;
            }
            prevGroupEnd.next = kth;
            curr.next = nextGroupStart;

            prevGroupEnd= curr;
            curr = nextGroupStart;
        }
        return dummy.next;
    }

    private ListNode kthNode(ListNode curr, int k) {
        while (curr != null && k >1){
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public static void main(String[] args) {
        LeetCode2525ReverseNodesInKGroup solution = new LeetCode2525ReverseNodesInKGroup();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = solution.reverseKGroup(head, k);

        // Print the reversed list
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }

}
