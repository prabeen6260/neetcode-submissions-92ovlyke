class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x==0)return true;
        int reverse=0;
        int org=x;
        while(x!=0){
            int mod=x%10;
            x=x/10;
            reverse=(reverse*10)+mod;
        }
        if(org==reverse)return true;
        return false;
        
    }
}