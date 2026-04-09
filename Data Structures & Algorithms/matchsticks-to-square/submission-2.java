class Solution {
    int count=0;
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length;
        if(n<4)return false;
        int sum=0;
        for(int num:matchsticks)sum+=num;
        if(sum%4!=0)return false;
        int required = sum/4;
         int[] sides = new int[4];
        Arrays.sort(matchsticks);
        return backtrack(matchsticks,required,n-1,sides);
    }
    private boolean backtrack(int[] matchsticks,int required,int index,int[] sides){
        if(index==-1){
            for(int length:sides){
                if(length!=required)return false;
            }
            return true;
        }
        for(int i=0;i<sides.length;i++){
            if(sides[i]+matchsticks[index]<=required){
                sides[i]+=matchsticks[index];
                if(backtrack(matchsticks,required,index-1,sides)){
                    return true;
                }
                sides[i]-=matchsticks[index];
            }
        }
        return false;
    }
}