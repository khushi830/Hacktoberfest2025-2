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
class Solution 
{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode head=new ListNode(0);
        ListNode temp=head;
        while(true)
        {
            ListNode one=list1;
            ListNode two=list2;
            if(list1==null)
            {
                temp.next=list2;
                list2=null;
                break;
            }
            else if(list2==null)
            {
                temp.next=list1;
                list1=null;
                break;
            }

            if(one.val>two.val)
            {
                temp.next=two;
                list2=two.next;
                temp.next.next=null;
                temp=temp.next;
            }
            else if(one.val<two.val)
            {
                temp.next=one;
                list1=one.next;
                temp.next.next=null;
                temp=temp.next;
            }
            else
            {
                temp.next=one;
                list1=one.next;
                temp.next.next=null;
                temp=temp.next;

                temp.next=two;
                list2=two.next;
                temp.next.next=null;
                temp=temp.next;
            }
        }
        head=head.next;
        return head;
    }
    
    public ListNode mergeKLists(ListNode[] lists)
    {        
        int len=lists.length;
        if(len<1)
            return null;

        ListNode temp=lists[0];
        for(int i=1;i<len;i++)
        {
            temp=mergeTwoLists(lists[i],temp);
        }
        
        return temp;
    }
}
