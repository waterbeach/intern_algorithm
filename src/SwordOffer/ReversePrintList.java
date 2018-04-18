package SwordOffer;
import java.util.ArrayList;
import java.util.Stack;

/*
 从尾到头打印列表
 */
public class ReversePrintList {
    static ArrayList<Integer> list = new ArrayList();
    // 不改变链表结构
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> list = new ArrayList();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){//栈弹出遍历
            list.add(stack.pop());
        }
//        for(Integer i : stack){ //集合遍历，栈底-》栈顶
//            list.add(i);
//        }
        return list;
    }

    // 递归实现，若链表特别长的时候容易调用栈溢出
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode!=null){
            if(listNode.next!=null)
                printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
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
        ArrayList<Integer> list = printListFromTailToHead2(a);
        for(Integer i : list){
            System.out.print(i+" ");
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
     this.val = val;
    }
}

