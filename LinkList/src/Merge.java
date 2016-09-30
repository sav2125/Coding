/**
 * Created by siddharthvarshney on 9/15/16.
 */
public class Merge {
    ListNode head = null;
    public void push(int val)
    {
        ListNode curr = head;
        if(curr == null)
        {
            head = new ListNode(val);
            return;
        }
        ListNode prev = null;
        while(curr != null)
        {
            prev = curr;
            curr = curr.next;
        }
        prev.next = new ListNode(val);
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
    public static void main(String args[])
    {
        Merge list1 = new Merge();
        Merge list2 = new Merge();
        list1.push(5);
        list1.push(10);
        list1.push(15);
        list2.push(2);
        list2.push(3);
        list2.push(20);
        ListNode merged = merge(list1.head, list2.head);
        print(merged);
    }
}
