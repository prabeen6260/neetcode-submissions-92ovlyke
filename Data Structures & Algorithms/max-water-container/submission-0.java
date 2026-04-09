class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int l=0;
        int r=n-1;
        int ans=0;
        int h=0;
        while(l<r){
            h=Math.min(heights[l],heights[r]);
            int area=h*(r-l);
            ans=Math.max(ans,area);
            if(heights[l]<heights[r])l++;
            else r--;
        }
        return ans;
    }
}
