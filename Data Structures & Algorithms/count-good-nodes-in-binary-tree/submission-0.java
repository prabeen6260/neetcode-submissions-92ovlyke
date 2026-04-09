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
    public int goodNodes(TreeNode root) {
        int max=root.val;
        int[] ans=new int[1];
        dfs(root,max,ans);
        return ans[0];
    }
    private void dfs(TreeNode root, int max, int[] ans){
        if(root==null)return;
        if(root.val>=max){
            ans[0]++;
            max=Math.max(max,root.val);
        }
        dfs(root.left,max,ans);
        dfs(root.right,max,ans);
    }
}
