class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++){
            index[i]=i;
        }
        Arrays.sort(index,(a,b)->tasks[a][0]==tasks[b][0]?Integer.compare(a,b):Integer.compare(tasks[a][0],tasks[b][0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->tasks[a][1]==tasks[b][1]?Integer.compare(a,b):Integer.compare(tasks[a][1],tasks[b][1]));
        long currTime=tasks[index[0]][0];
        int i=0;
        int x=0;
        int[] ans=new int[n];
        while(i<n || !pq.isEmpty()){
            while(i<n && tasks[index[i]][0]<=currTime){
                pq.add(index[i]);
                i++;
                
            }
            if(!pq.isEmpty()){
                int val=pq.poll();
                ans[x]=val;
                currTime+=tasks[val][1];
                x++;
            }
            else if(pq.isEmpty()){
                currTime=tasks[index[i]][0];
            }
        }
        return ans;
    }
}