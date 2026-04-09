class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<n;i++)map.add(new ArrayList<>());
        for(int[] edge:edges){
            map.get(edge[1]).add(edge[0]);
            map.get(edge[0]).add(edge[1]);
        }
        int count=0;
        boolean[] checked = new boolean[n];
        for(int i=0;i<n;i++){
            if(dfs(map,checked,i)){
                count++;
            }
        }
        return count;
        
    }
    private boolean dfs(List<List<Integer>> map,boolean[] checked,int i){
        if(checked[i])return false;
        checked[i]=true;
        for(int e: map.get(i)){
            dfs(map,checked,e);
        }
        return true;
    }
}
