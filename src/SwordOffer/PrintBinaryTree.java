package SwordOffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current != null)
                res.add(current.val);
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
        return res;
    }
    public static void main(String [] args){
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

        List<Integer> res = PrintFromTopToBottom(a);
        for(int i : res)
            System.out.print(i+" ");


    }
}

