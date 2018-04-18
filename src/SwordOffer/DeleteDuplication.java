package SwordOffer;

public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)
            return null;

        ListNode prev = null;
        ListNode node = pHead;

        while(node.next != null){
            ListNode next = node.next;
            boolean del = false;
            if(next.val == node.val){
                del = true;
            }
            if(del){
                int delVal = node.val;
                //ListNode toNode = node;
                while(node != null && node.val == delVal){
                    next = node.next;
                    node = next;
                }
                if(prev == null)
                    pHead = next;
                else {
                    prev.next = node;
                }
                if(node==null)
                    break;
            }
            else{
                prev = node;
                node = next;
            }

        }
        return pHead;
    }

    public static void main(String [] args){
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode result = deleteDuplication(a);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
