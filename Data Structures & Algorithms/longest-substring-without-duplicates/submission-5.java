class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int[] freq=new int[128];
        int l=0;
        int ans=0;
        for(int r=0;r<s.length();r++){
            int index=s.charAt(r);
            freq[index]++;
            while(freq[index]>1){
                freq[s.charAt(l)]--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
