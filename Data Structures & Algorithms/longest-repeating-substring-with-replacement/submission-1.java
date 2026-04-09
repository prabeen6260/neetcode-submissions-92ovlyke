class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left=0;
        int ans=0;
        int maxCount=0;
        for(int i=0;i<s.length();i++){
            int count = s.charAt(i)-'A';
            freq[count]++;
            maxCount=Math.max(maxCount,freq[count]);
            while((i-left+1)-maxCount>k){ //invalid window
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}
