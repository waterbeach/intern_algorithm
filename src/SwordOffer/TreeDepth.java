package SwordOffer;

public class TreeDepth {
    public static int treeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return leftDepth > rightDepth? leftDepth+1 : rightDepth+1;

    }

    public static void main(String [] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.right = f;
//        e.left = g;

        System.out.println(treeDepth(a));
    }
}
