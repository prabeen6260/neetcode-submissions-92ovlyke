class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Character> q=new ArrayDeque<>();
        int d_count=0;
        int r_count=0;
        int n=senate.length();
        for(char c:senate.toCharArray()){
            if(c=='R'){
                r_count++;
                q.offer(c);
            }
            else{
                d_count++;
                q.offer(c);
            }
        }
        int r_ban=0;
        int d_ban=0;
        while(d_count !=0 && r_count!=0){
            char c=q.poll();
            if(c=='R' && r_ban==0){
                d_ban++;
                q.offer('R');
            }
            else if(c=='D' && d_ban==0){
                r_ban++;
                q.offer('D');
            }
            else if(c=='R' && r_ban>0){
                r_count--;
                r_ban--;
            }
            else if(c=='D' && d_ban>0){
                d_count--;
                d_ban--;
            }
        }
        return d_count==0?"Radiant":"Dire";
    }
}