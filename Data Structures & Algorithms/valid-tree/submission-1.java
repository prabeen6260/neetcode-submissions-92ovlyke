class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)return false;
        List<List<Integer>> map = new ArrayList<>();
        //List<List<Integer>> map2 = new ArrayList<>();
        for(int i=0;i<n;i++)map.add(new ArrayList<>());
        for(int[] e:edges){
            map.get(e[1]).add(e[0]);
            map.get(e[0]).add(e[1]);
        }
        int[] visited=new int[n];
        if(hasCycle(map,visited,0,-1))return false;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) return false; 
        }
        return true;
    }
    private boolean hasCycle(List<List<Integer>> map,int[] visited,int index,int parent){
        visited[index]=1;
        for(int neighbor:map.get(index)){
            if(neighbor==parent)continue;
            if(visited[neighbor]==1)return true;
            if(visited[neighbor]==0){
                if(hasCycle(map,visited,neighbor,index))return true;
            }
        }
        visited[index]=2;
        return false;
    }
}
