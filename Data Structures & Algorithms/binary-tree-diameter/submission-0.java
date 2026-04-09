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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int[] max=new int[1];
        dfs(root,max);
        return max[0];

        
    }
    private int dfs(TreeNode root,int[] max){
        if(root==null)return 0;
        int left=0;
        int right=0;
        left=dfs(root.left,max);
        right=dfs(root.right,max);
        max[0]=Math.max(max[0],left+right);
        return Math.max(left,right)+1;
    }
}
