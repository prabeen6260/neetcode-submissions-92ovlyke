class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        String newS=s.toLowerCase();
        int[] freq=new int[26];
        int l=0;
        int r=0;
        int count=0;
        int maxFreq=0;
        for(char c:newS.toCharArray()){
            freq[c-'a']++;
            int size=r-l+1;
            maxFreq=Math.max(maxFreq,freq[c-'a']);
            if(size-maxFreq>k){
                freq[newS.charAt(l)-'a']--;
                l++;
            }
            else{
                count=Math.max(count,size);
            }
            r++;
        }
        return count;
    }
}
