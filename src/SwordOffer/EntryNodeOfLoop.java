package SwordOffer;

public class EntryNodeOfLoop {
    public static ListNode entryNodeOfLoop(ListNode pHead)
    {
        ListNode node = LoopNode(pHead);
        if(node == null)//�޻�
            return null;
        int loopLen = 1;
        ListNode tmp = node;
        while(tmp.next!=node) {
            loopLen += 1;
            tmp = tmp.next;
        }

        ListNode first = pHead;
        ListNode later = pHead;
        for(int i = 0; i< loopLen;i++)
            first = first.next;
        while(first != later){
            first = first.next;
            later = later.next;
        }

        return first;
    }

    /*
        �����ڻ������ػ��е�ĳ���ڵ㣻���򷵻�null;
     */
    public static ListNode LoopNode(ListNode pHead)
    {
        if(pHead == null)
            return null;
        ListNode pLater = pHead.next;//��һ��
        if(pLater == null)
            return null;
        ListNode pFirst = pLater.next;//������

        while(pLater != null && pFirst != null){

            if(pFirst == pLater)
                return pFirst;

            pFirst = pFirst.next;
            pLater = pLater.next;
            if(pLater != null)
                pLater = pLater.next;
        }
        return null;
    }

    public static void main(String [] args){
        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        ListNode f = new ListNode(6);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = c;

        ListNode result = entryNodeOfLoop(a);
        if(result == null)
            System.out.println("null");
        System.out.println(result.val);
    }
}
