package SwordOffer;

public class IsBalancedTree {
    public static boolean isBalanced = true;
    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;

        int depth = treeDepth(root);
        return isBalanced;
//        int leftDepth = TreeDepth.treeDepth(root.left);
//        int rightDepth = TreeDepth.treeDepth(root.right);
//
//        int diff = leftDepth - rightDepth;
//        if(diff < -1 || diff > 1)
//            return false;
//        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static int treeDepth(TreeNode root){
        if(root == null)
            return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        int diff = left - right;
        if(diff<-1 || diff>1)
            isBalanced = false;
        return left > right? left+1:right+1;

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

        System.out.println(IsBalanced_Solution(a));
    }
}
