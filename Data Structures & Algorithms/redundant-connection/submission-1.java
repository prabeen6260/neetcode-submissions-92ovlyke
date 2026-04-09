class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        for(int i=1;i<parent.length;i++)parent[i]=i;
        int[] ans = new int[2];
        for(int[] e:edges){
            int root1 = find(parent,e[0]);
            int root2 = find(parent,e[1]);
            if(root1==root2){
                ans[0]=e[0];
                ans[1]=e[1];
            }
            //union
            parent[root1]=root2;
        }
        return ans;
    }
    private int find(int[] parent, int i){
        if(parent[i]==i)return i;
        return find(parent,parent[i]);
    }
}
