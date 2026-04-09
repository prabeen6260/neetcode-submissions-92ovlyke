class Solution {
    public int mySqrt(int x) {
        long l=0;
        long r=x;
        long ans=0;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(mid*mid<=x){
                l=mid+1;
                ans=Math.max(mid,ans);
            }
            else {
                r=mid-1;
            }
        }
        return (int)ans;
    }
}