class Solution {
    public int lengthOfLongestSubstring(String s) {
        //if(s.length()==0)return 0;
        //if(s.length()==1)return 1;
        int l=0;
        int n=s.length();
        char[] freq = new char[128];
        int ans=0;
        for(int r=0;r<n;r++){
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
