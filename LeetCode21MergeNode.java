package problemSolving;

public class LeetCode21MergeNode {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;

        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
       ListNode dummy = new ListNode(-1);
       ListNode current = dummy;

       while (list1 != null && list2 != null){
           if(list1.val <= list2.val){
               current.next = list1;
               list1 = list1.next;
           }
           else {
               current.next = list2;
               list2 = list2.next;
           }
           current = current.next;
       }
       if(list1 != null){
           current.next = list1;
       }
       else {
           current.next = list2;
       }
       return  dummy.next;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        // Create the first linked list: 1 -> 2 -> 3
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        // Create the second linked list: 4 -> 5
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(1);

        System.out.println("First List:");
        printList(head1);

        System.out.println("Second List:");
        printList(head2);

        // Join the two linked lists
        ListNode joinedHead = mergeTwoLists(head1, head2);

        System.out.println("Joined List:");
        printList(joinedHead);
    }

    }
