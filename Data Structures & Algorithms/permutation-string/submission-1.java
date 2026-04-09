class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int left =0;
        int[] freq=new int[26];
        int[] windowFreq= new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            windowFreq[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq,windowFreq))return true;
        int right = s1.length();
        while(right<s2.length()){
            windowFreq[s2.charAt(right)-'a']++;
            windowFreq[s2.charAt(left)-'a']--;
            left++;
            right++;
            if(Arrays.equals(freq,windowFreq))return true;
        }
        return false;
    }
}
