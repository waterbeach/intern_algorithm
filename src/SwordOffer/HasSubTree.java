package SwordOffer;

public class HasSubTree {
    public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1!=null && root2!=null) {
            if (root1.val == root2.val) {
                result = IsSubTree(root1, root2);
            }
            if (!result && root1.left != null)
                result = hasSubtree(root1.left, root2);
            if (!result && root1.right != null)
                result = hasSubtree(root1.right, root2);
        }
        return result;
    }

    public static boolean IsSubTree(TreeNode root1,TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return IsSubTree(root1.left,root2.left) && IsSubTree(root1.right,root2.right);
    }

    public static void main(String [] args){
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);

        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(2);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

        h.left = i;
        h.right = j;

        System.out.println(hasSubtree(a,h));

    }
}
