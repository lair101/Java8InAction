package com.guo.j8.nineChapter.BT;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 
 */
public class ValidateBST {

    //serialize and deserilize

    public String serialize(TreeNode root){
        //literatrly pre-order traversal the BT
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null ) return null;
        q.offer(root);
        while(!q.isEmpty()){
            //visit this root
            TreeNode tmp = q.poll();
            if(tmp == null){
                sb.append("null").append(",");
            }else{
                sb.append(String.valueOf(tmp.val)).append(",");
                q.offer(tmp.left);
                q.offer(tmp.right);
            }

        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        if(str.length==0)  return null;
        Queue<String> q = new LinkedList<String>();
        q.addAll(Arrays.asList(str));
        return deserialize(q);
    }


    public TreeNode deserialize(Queue<String> q){
        String s = q.poll();
        if(s.equals("null")){
            return null;
        }else{
            TreeNode n = new TreeNode(Integer.valueOf(s));
            n.left= deserialize(q);
            n.right= deserialize(q);
            return n;
        }
    }


    //is Valid or not

    public Boolean isValidBST(TreeNode root){

        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if(root == null) return true;

        return isValidBST(root,left,right);
    }

    private Boolean isValidBST(TreeNode root, int left, int right) {
        if (root == null) return true;
        if (root.val >= right || root.val <= left) return false;
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }


    //is balance tree
    public boolean isBalanced(TreeNode root, Height height)
    {
        /* If tree is empty then return true */
        if (root == null)
        {
            height.height = 0;
            return true;
        }

        /* Get heights of left and right sub trees */
        Height lheight = new Height(), rheight = new Height();
        boolean l = isBalanced(root.left, lheight);
        boolean r = isBalanced(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;

        /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height = (lh > rh? lh: rh) + 1;

        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if ((lh - rh >= 2) ||
                (rh - lh >= 2))
            return false;

        /* If this node is balanced and left and right subtrees
           are balanced then return true */
        else return l && r;
    }


    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    int height(TreeNode node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }


    // A wrapper class used to modify height across
    // recursive calls.
    class Height
    {
        int height = 0;
    }
}
