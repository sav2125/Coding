import java.util.List;

/**
 * Created by siddharthvarshney on 9/15/16.
 */
public class MergeSort {
    ListNode head = null;
    static ListNode sort(ListNode headptr)
    {
        if(headptr == null || headptr.next == null)
        {
            return headptr;
        }
        ListNode slow = headptr;
        ListNode fast = headptr;
        ListNode prev_slow = null;
        while(fast != null && fast.next != null)
        {
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow;
        prev_slow.next = null;
        headptr = sort(headptr);
        head2 = sort(head2);
        ListNode merge = merge(headptr,head2);
        return merge;
    }
    static ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode dummy = new ListNode(0);
        ListNode newhead = dummy;
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while(curr1 != null && curr2 != null)
        {
            if (curr1.val <= curr2.val)
            {
                dummy.next = curr1;
                curr1 = curr1.next;
                dummy = dummy.next;
            }
            else
            {
                dummy.next = curr2;
                curr2 = curr2.next;
                dummy = dummy.next;
            }
        }
        if(curr1 != null)
        {
            dummy.next = curr1;
        }
        else if(curr2 != null)
        {
            dummy.next = curr2;
        }
        return newhead.next;
    }
    static public void print(ListNode start)
    {
        ListNode curr = start;
        while(curr != null)
        {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Merge list1 = new Merge();
        list1.push(5);
        list1.push(10);
        list1.push(15);
        list1.push(2);
        list1.push(3);
        list1.push(20);
        ListNode merged = sort(list1.head);
        print(merged);
    }
}
