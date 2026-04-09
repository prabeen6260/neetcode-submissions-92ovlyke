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
        List<Integer> ans = new ArrayList<>();
        int count=0;
        while(!q.isEmpty()){
            int course=q.poll();
            ans.add(course);
            count++;
            for(int c:map.get(course)){
                indegree[c]--;
                if(indegree[c]==0)q.offer(c);
            }
        }
        int[] arr=new int[numCourses];
        for(int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return count==numCourses?arr:new int[0];
    }
}
