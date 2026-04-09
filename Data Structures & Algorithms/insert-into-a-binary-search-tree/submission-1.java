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
        Deque<TreeNode> q=new ArrayDeque<>();
        if(root==null)return new TreeNode(val);
        TreeNode curr = root;
        q.offer(curr);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(val<node.val){
                if(node.left!=null){
                    q.offer(node.left);
                }
                else {
                    node.left=new TreeNode(val);
                }
            }
            else {
                if(node.right!=null){
                    q.offer(node.right);
                }
                else node.right=new TreeNode(val);
            }
        }
        return root;
    }
}