class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if(n1>n2)return false;
        int[] freq=new int[26];
        for(int i=0;i<n1;i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        if(isZero(freq))return true;
        for(int i=n1;i<n2;i++){
            freq[s2.charAt(i)-'a']--;
            freq[s2.charAt(i-n1)-'a']++;
            if(isZero(freq))return true;
        }
        return false;
    }
    private boolean isZero(int[] freq){
        for(int n:freq){
            if(n!=0)return false;
        }
        return true;
    }
}
