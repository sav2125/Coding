/**
 * Created by siddharthvarshney on 9/15/16.
 */
public class Palindrome {
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
    public void print(ListNode start)
    {
        ListNode curr = start;
        while(curr != null)
        {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public int checkPalindrome()
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        int count = 0;
        ListNode countptr = head;
        while(countptr != null)
        {
            count++;
            countptr = countptr.next;
        }
        if(count == 1)
            return 1;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhead = null;
        if(fast == null)
        {
            prev.next = null;
            secondhead = slow;
        }
        else
        {
            prev.next = null;
            secondhead = slow.next;
        }
        print(head);
        print(secondhead);

        secondhead = reverse(secondhead);
        ListNode curr1 = head;
        ListNode curr2 = secondhead;
        while(curr1 != null && curr2 != null)
        {
            if(curr1.val != curr2.val)
                return 0;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if( (curr1 == null && curr2 != null) || (curr2 == null && curr1 != null))
            return 0;
        return 1;
    }
    public ListNode reverse(ListNode start)
    {
        ListNode current = start;
        ListNode next = null;
        ListNode prev = null;
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start = prev;
        return start;
    }
    public static  void main(String args[])
    {
        Palindrome list = new Palindrome();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(2);
        list.push(1);
        System.out.print(list.checkPalindrome());
    }
}
