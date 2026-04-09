class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length)return false;
        int[] parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        for(int[] edge:edges){
            int root1=find(edge[0],parent);
            int root2=find(edge[1],parent);

            if(root1==root2)return false;
            parent[root2]=parent[root1];
        }
        return true;
    }
    private int find(int edge,int[] parent){
        if(parent[edge]==edge)return edge;
        return find(parent[edge],parent);
    }
}
