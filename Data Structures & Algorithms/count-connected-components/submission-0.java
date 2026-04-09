class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,visited,i);
                count++;
            }
        }
        return count;
    }
    public void dfs(List<List<Integer>> graph,boolean[] visited,int i){
        if(visited[i])return;
        visited[i]=true;
        for(int start:graph.get(i)){
            dfs(graph,visited,start);
        }
    }
}
