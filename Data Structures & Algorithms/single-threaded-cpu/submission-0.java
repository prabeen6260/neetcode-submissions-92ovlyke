class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][] newTasks=new int[n][3];
        int[] ans=new int[tasks.length];
        for(int i=0;i<n;i++){
            newTasks[i]=new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(newTasks,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]==b[1]?Integer.compare(a[2],b[2]):Integer.compare(a[1],b[1]));
        int currTime=newTasks[0][0];
        int i=0;
        int x=0;
        while(i<n || !pq.isEmpty()){
            while(i<n && newTasks[i][0]<=currTime){
                pq.offer(newTasks[i]);
                i++;
            }
            if(!pq.isEmpty()){
                int[] val=pq.poll();
                ans[x]=val[2];
                x++;
                currTime+=val[1];
            }
            if(i<n && newTasks[i][0]>currTime && pq.isEmpty()){
                currTime=newTasks[i][0];
            }
        }
        return ans;
    }
}