class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        int[] indegree=new int[numCourses];
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)map.add(new ArrayList<>());
        for(int[] pre: prerequisites){
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.add(i);
        }
        int[] ans = new int[numCourses];
        int count=0;
        while(!q.isEmpty()){
            int course=q.poll();
            ans[count]=course;
            count++;
            for(int c:map.get(course)){
                indegree[c]--;
                if(indegree[c]==0)q.offer(c);
            }
        }
        return count==numCourses?ans:new int[0];
    }
}
