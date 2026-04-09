class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if(n1>n2)return false;
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(char c:s1.toCharArray())freq1[c-'a']++;
        int l=0;
        for(int r=0;r<n2;r++){
            freq2[s2.charAt(r)-'a']++;
            if(r-l+1==n1){
                if(Arrays.equals(freq1,freq2))return true;
                freq2[s2.charAt(l)-'a']--;
                l++;
            }
        }
        return false;
    }
}
