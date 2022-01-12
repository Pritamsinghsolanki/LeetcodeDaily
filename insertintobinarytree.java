/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return solve(root,val);
    }
    public static TreeNode solve(TreeNode root,int val){
        if(root==null) return new TreeNode(val);
        if(root.val<val){
            root.right=solve(root.right,val);
        }else{
            root.left=solve(root.left,val);
        }
        return root;
    }
}