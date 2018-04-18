package SwordOffer;

import sun.reflect.generics.tree.Tree;

//根据先序遍历和中序遍历重建二叉树
public class RestructTree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0 || in.length==0)
            return null;
        TreeNode result = construct(pre,in,0,pre.length-1,0,in.length-1);
        return result;
    }

    public static TreeNode construct(int [] pre,int [] in, int preStart,int preEnd,int inStart,int inEnd){
        if(preEnd < preStart || inEnd < inStart)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);
        root.left = null;
        root.right = null;
        //从中序中查找根节点
        int inRoot = -1;
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]) {
                inRoot = i;
                break;
            }
        }
        int leftLen = inRoot-inStart;
        int rightLen = inEnd - inRoot;
        root.left = construct(pre,in,preStart+1,preStart+leftLen,inStart,inRoot-1);
        root.right = construct(pre,in,preStart+leftLen+1,preEnd,inRoot+1,inEnd);
        return root;
    }

    public static void main(String [] args){
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        TreeNode res = reConstructBinaryTree(pre,in);
        afterOrder(res);
    }

    public static void afterOrder(TreeNode node){
        if(node==null){
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.val);
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}