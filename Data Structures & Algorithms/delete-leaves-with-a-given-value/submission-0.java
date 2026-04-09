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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode curr=root;
        return dfs(curr,target);
    }
    private TreeNode dfs(TreeNode curr,int target){
        if(curr==null)return null;
        curr.left =dfs(curr.left,target);
        curr.right =dfs(curr.right,target);
        if(curr.left==null && curr.right==null && curr.val==target){
            curr=null;
        }
         return curr;
    }
}