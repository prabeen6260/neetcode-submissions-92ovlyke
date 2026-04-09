class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        int[] parent = new int[n];
        int[] ans=new int[2];
        for(int i=0;i<n;i++)parent[i]=i;
        for(int[] e:edges){
            int root_u = find(parent,e[0]);
            int root_v = find(parent,e[1]);
            if(root_u==root_v){
                ans[0]=e[0];
                ans[1]=e[1];
                break;
            };
            parent[root_u]=root_v;
        }
        return ans;
    }
    private int find(int[] parent,int i){
        if(parent[i]==i)return i;
        parent[i]=find(parent,parent[i]);
        return parent[i];
    }
}
