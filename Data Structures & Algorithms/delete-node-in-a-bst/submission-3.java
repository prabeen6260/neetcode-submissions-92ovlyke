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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return root;
        TreeNode curr=root;
        return dfs(curr,key);
    }
    private TreeNode dfs(TreeNode node,int key){
        if(node==null)return null;
        if(node.val==key){
            //leaf
            if(node.left==null && node.right==null){
                node=null;
                return node;
            }
            else if(node.left!=null && node.right==null){//one child 
                node=node.left;
                return node;
            }
            else if(node.right!=null && node.left==null){
                node=node.right;
                return node;
            }
            else{
                TreeNode min=node.right;
                while(min.left!=null){
                    min=min.left;
                }
                node.val=min.val;
                node.right=dfs(node.right,min.val);
                return node;
            }
        }
        else if(key<node.val){
            node.left = dfs(node.left,key);
            return node;
        }
        else{
            node.right = dfs(node.right,key);
            return node;
        }
    }
}