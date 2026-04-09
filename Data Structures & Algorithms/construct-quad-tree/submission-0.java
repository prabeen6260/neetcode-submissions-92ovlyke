/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n=grid.length;
        return dfs(grid,n,0,0);
    }
    private Node dfs(int[][] grid, int n, int r, int c){
        if(n==1)return new Node(grid[r][c]==1,true);

        int mid=n/2;
        Node topleft = dfs(grid,mid,r,c);
        Node topright=dfs(grid,mid,r,c+mid);
        Node bottomleft=dfs(grid,mid,r+mid,c);
        Node bottomright=dfs(grid,mid,r+mid,c+mid);

        if(topleft.isLeaf && topright.isLeaf && bottomleft.isLeaf && bottomright.isLeaf
        && topleft.val==topright.val && topleft.val==bottomleft.val && topleft.val==bottomright.val){
            return new Node(topleft.val,true);
        }

        return new Node(false,false,topleft,topright,bottomleft,bottomright);
    }
}