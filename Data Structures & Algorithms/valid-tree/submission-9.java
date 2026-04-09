class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length)return false;
        int[] parent=new int[n];
        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        return union(edges,parent,rank);
    }
    // find
    private int find(int edge,int[] parent){
        if(edge==parent[edge])return edge;
        return parent[edge]=find(parent[edge],parent);
    }
    //
    private boolean union(int[][] edges,int[]parent,int[] rank){
        for(int[] edge:edges){
            int e0=edge[0];
            int e1=edge[1];
            int parent1=find(e0,parent);
            int parent2=find(e1,parent);
            if(parent1==parent2)return false;
            if(rank[parent1]==rank[parent2]){
                rank[parent1]++;
                parent[parent2]=parent1;
            }
            else if(rank[parent1]<rank[parent2]){
                parent[parent1]=parent2;
            }
            else if(rank[parent2]<rank[parent1]){
                parent[parent2]=parent1;
            }
        }
        return true;
    }
}
