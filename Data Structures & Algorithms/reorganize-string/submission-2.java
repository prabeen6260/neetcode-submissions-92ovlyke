class Solution {
    public String reorganizeString(String s) {
        StringBuilder string = new StringBuilder();
        int[] freq=new int[26];
        for(char c:s.toCharArray())freq[c-'a']++;
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<26;i++){
            if(freq[i]!=0)pq.offer(new int[]{freq[i],i});
        }
        if(pq.peek()[0]>(s.length()+1)/2)return "";
        int curr=0;
        int[] prev=null;
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int count=arr[0];
            int c=arr[1];
            string.append((char)(c+'a'));
            count-=1;
            if(prev!=null)pq.add(prev);
            if(count!=0){
                prev=new int[]{count,c};
            }
            else prev=null;
        }
        return string.length()==s.length()?string.toString():"";
    }
}