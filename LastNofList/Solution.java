public class Solution {


    class ListNode{
        int value;
        ListNode next;
        public ListNode( int value ){
            this.value = value;
        }
    }


    public ListNode getLastK(ListNode head, int k){
        if(int k <= 0 || head == null)
           return null;

        ListNode [] res = new ListNode[1];
        findReverseIndex(head, k, res);
        return res[0];
    }

    private int findReverseIndex(ListNode head, int k, ListNode[] res){
        
        if( head == null )
           return 0;

        int rIndex = findReverseIndex(head.next, k, res);
        if(rIndex == k)
           res[0] = head;
        return rIndex; 
    }



    public static void main(String [] args){

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        
        Solution sol = new Solution();
        for(int i = 0; i<=6; ++i)
            System.out.println(sol.getLastK(head1, i));

    }
}
