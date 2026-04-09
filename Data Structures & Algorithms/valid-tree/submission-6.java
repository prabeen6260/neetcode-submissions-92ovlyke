class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length)return false;
        int[] parent=new int[n];
        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int[] edge:edges){
            int parent1=find(edge[0],parent);
            int parent2=find(edge[1],parent);

            if(parent1==parent2)return false;
            parent[parent2]=parent1;
        }
        return true;
    }
    // find
    private int find(int edge,int[] parent){
        if(edge==parent[edge])return edge;
        return edge=find(parent[edge],parent);
    }
}
