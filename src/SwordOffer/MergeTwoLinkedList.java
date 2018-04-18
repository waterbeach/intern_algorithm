package SwordOffer;

public class MergeTwoLinkedList {
    public static ListNode Merge(ListNode list1,ListNode list2) {

        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        //初始化
        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
            list1 = list1.next;
        }
        else{
            head = list2;
            list2 = list2.next;
        }
        ListNode current = head;

        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
            else{
                current.next = list1;
                current = list1;
                list1 = list1.next;
            }
        }
        while(list1!=null){
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }
        while(list2!=null){
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }

        return head;
    }

    public static ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        //初始化
        ListNode head = null;

        if(list1.val > list2.val){
            head = list2;
            head.next = Merge2(list1,list2.next);
        }
        else{
            head = list1;
            head.next = Merge2(list1.next,list2);
        }
        return head;
    }

    public static void main(String [] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode f = new ListNode(2);
        ListNode i = new ListNode(4);
        ListNode j = new ListNode(6);
        ListNode k = new ListNode(8);
        ListNode l = new ListNode(10);
        i.next = j;
        j.next = k;
        k.next = l;
        f.next = i;

        ListNode result = Merge2(a,f);
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
