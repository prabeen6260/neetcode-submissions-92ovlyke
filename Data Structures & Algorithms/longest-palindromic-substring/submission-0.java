class Solution {
    public String longestPalindrome(String s) {
        int resLen=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            // for odd length
            int left=i;
            int right=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }  
            if(resLen<right-left+1){
                res=left+1;
                resLen=right-left-1;
            }
        }
        String s1=s.substring(res,res+resLen);
        res=0;
        resLen=0;
        for(int i=0;i<s.length();i++){
            // for even length
            int left=i;
            int right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(resLen<right-left+1){
                res=left+1;
                resLen=right-left-1;
            }
        }
        String s2=s.substring(res,res+resLen);
        return s1.length()>s2.length()?s1:s2;
    }
}
