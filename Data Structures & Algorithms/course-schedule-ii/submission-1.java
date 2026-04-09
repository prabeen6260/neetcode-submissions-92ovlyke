class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      List<List<Integer>> map = new ArrayList<>();
      for(int i=0;i<numCourses;i++)map.add(new ArrayList<>());
      int[] indegree = new int[numCourses];
      for(int[] pre:prerequisites){
        map.get(pre[1]).add(pre[0]);
        indegree[pre[0]]++;
      }  
      Deque<Integer> q=new ArrayDeque<>();
      for(int i=0;i<numCourses;i++){
        if(indegree[i]==0)q.offer(i);
      }
      int[] ans=new int[numCourses];
      int count=0;
      while(!q.isEmpty()){
        int indx=q.poll();
        ans[count]=indx;
        count++;
        for(int c:map.get(indx)){
            indegree[c]--;
            if(indegree[c]==0){
                q.offer(c);
            }
        }
      }
      if(count==numCourses)return ans;
      return new int[0];
    }
}
