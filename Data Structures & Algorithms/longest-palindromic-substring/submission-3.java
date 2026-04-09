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
            if(resLen<right-left-1){
                res=left+1;
                resLen=right-left-1;
            }
            // for even length
            left=i;
            right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(resLen<right-left-1){
                res=left+1;
                resLen=right-left-1;
            }
        }
        return s.substring(res,res+resLen);
    }
}
