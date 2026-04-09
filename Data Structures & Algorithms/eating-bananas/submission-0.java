class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int maxPile =0;
        for(int pile:piles)maxPile=Math.max(maxPile,pile);
        int l=1;
        int ans=maxPile;
        while(l<=maxPile){
            int mid = l + (maxPile-l)/2;
            if(canFinish(piles,mid,h)){
                maxPile=mid-1;
                ans=Math.min(ans,mid);
            }
            else if(!canFinish(piles,mid,h)){
                l=mid+1;
            }
        }
        return ans;
    }
    private boolean canFinish(int[] piles, int k, int h){
        int hours =0;
        for(int pile: piles){
            hours+= Math.ceil(pile/(double)k);
        }
        if(hours<=h)return true;
        return false;
    }
}
