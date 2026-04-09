class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length)return false;
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] edge:edges){
            int root1=find(edge[0],parent);
            int root2=find(edge[1],parent);
            if(!union(root1,root2,parent,rank)){
                return false;
            }
        }
        return true;
    }
    private int find(int i,int[] parent){
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i],parent);
    }
    private boolean union(int root1,int root2,int[] parent,int[] rank){
        if(root1!=root2){
            if(rank[root1]>rank[root2]){
                parent[root2]=root1;
            }
            else if(rank[root1]<rank[root2]){
                parent[root1]=root2;
            }
            else{
                rank[root1]++;
                parent[root2]=root1;
            }
        }
        else return false;
        return true;
    }
}
