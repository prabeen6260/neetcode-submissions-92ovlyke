class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<numCourses;i++)map.add(new ArrayList<>());
        for(int[] preq:prerequisites){
            map.get(preq[1]).add(preq[0]);
        }
        int[] state=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(state[i]==0 && hasCycle(map,state,i))return false;
        }
        return true;
    }
    private boolean hasCycle(List<List<Integer>> map,int[] state,int index){
        if(state[index]==1) return true;
        if(state[index]==2)return false;
        state[index]=1;
        for(int c:map.get(index)){
            if(hasCycle(map,state,c))return true;
        }
        state[index]=2;
        return false;
        
    }
}
