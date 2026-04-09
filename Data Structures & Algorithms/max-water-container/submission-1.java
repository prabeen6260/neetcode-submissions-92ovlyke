class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int l=0;
        int r=n-1;
        int area=0;
        while(l<r){
            int height=Math.min(heights[l],heights[r]);
            int breadth=r-l;
            if(height==heights[l])l++;
            else r--;
            area=Math.max(area,height*breadth);
        }
        return area;
    }
}
