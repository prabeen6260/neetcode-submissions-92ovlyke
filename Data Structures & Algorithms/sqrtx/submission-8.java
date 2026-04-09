class Solution {
    public int mySqrt(int x) {
        if (x==0)return 0;
        if(x==1)return 1;
        int l=0;
        int r=x;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid!=0 && mid<=x/mid){
                l=mid+1;
                ans=Math.max(mid,ans);
            }
            else {
                r=mid-1;
            }
        }
        return ans;
    }
}