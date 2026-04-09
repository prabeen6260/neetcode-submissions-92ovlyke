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
    int curr=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)map.put(inorder[i],i);
        return dfs(preorder,map,0,preorder.length-1);
    }
    private TreeNode dfs(int[] preorder,Map<Integer,Integer> map,int left,int right){
        if(left>right)return null;
        int root=preorder[curr];
        curr++;
        TreeNode node=new TreeNode(root);
        int mid = map.get(root);
        node.left=dfs(preorder,map,left,mid-1);
        node.right=dfs(preorder,map,mid+1,right);
        return node;
    }
}
