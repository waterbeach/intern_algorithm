package SwordOffer;

public class ReverseLinkedlist {
    public static ListNode ReverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode currentNode = head;
        ListNode prevNode = null;

        while(currentNode!=null){
            ListNode nextNode = currentNode.next;
            if(nextNode==null)
                reverseHead = currentNode;

            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return reverseHead;
    }

    public static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode reverseHead = null;
        ListNode prev = null;

        while(current != null){
            ListNode next = current.next;
            if(next == null){
                reverseHead = current;
            }
            current.next = prev;

            prev = current;
            current = next;
        }
        return reverseHead;

    }

    public static void main(String [] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode result = ReverseList(a);
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}

