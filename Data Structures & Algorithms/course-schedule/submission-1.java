class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<numCourses;i++)map.add(new ArrayList<>());
        Deque<Integer> q= new ArrayDeque<>();
        int[] indegree = new int[numCourses];
        for(int[] pre:prerequisites){
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.offer(i);
        }
        int taken=0;
        while(!q.isEmpty()){
            int courseId=q.poll();
            taken++;
            for(int c:map.get(courseId)){
                indegree[c]--;
                if(indegree[c]==0)q.offer(c);
            }
        }
        if(taken==numCourses)return true;
        return false;
    }
}
